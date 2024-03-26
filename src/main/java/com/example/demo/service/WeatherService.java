package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Weather;
import com.example.demo.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;

	public List<Weather> getAllWeather() {
		return weatherRepository.findAll();
	}

	public Weather addWeather(Weather weather) {
		return weatherRepository.save(weather);
	}
}
