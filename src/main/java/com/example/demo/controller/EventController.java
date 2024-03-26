package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;

@RestController

public class EventController {
	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@PostMapping("/upload")
	public Event addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
	}

	@PostMapping("/uploadcsvdata")
	public String uploadEvents(@RequestParam("file") MultipartFile file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			boolean isFirstLine = true; // Flag to skip the first line
			while ((line = br.readLine()) != null) {
				if (isFirstLine) {
					isFirstLine = false;
					continue; // Skip the first line
				}
				String[] data = line.split(",");
				Event event = new Event();
				event.setEventName(data[0]);
				event.setCityName(data[1]);
				event.setDate(data[2]);
				event.setTime(data[3]);
				event.setLatitude(Double.parseDouble(data[4]));
				event.setLongitude(Double.parseDouble(data[5]));
				eventService.addEvent(event);
			}
			return "File uploaded successfully";
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to upload file";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Invalid latitude/longitude format";
		}
	}

}