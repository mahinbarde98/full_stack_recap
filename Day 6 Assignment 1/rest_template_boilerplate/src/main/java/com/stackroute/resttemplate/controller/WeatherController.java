package com.stackroute.resttemplate.controller;

import com.stackroute.resttemplate.model.Weather;
import com.stackroute.resttemplate.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //create a method to get the weather of a city
    @GetMapping("/weather/{city}")
    public Weather getWeather(@PathVariable String city) {

        return  weatherService.getWeather(city);
    }
}
