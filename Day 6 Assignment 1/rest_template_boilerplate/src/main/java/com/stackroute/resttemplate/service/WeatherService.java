package com.stackroute.resttemplate.service;

import com.stackroute.resttemplate.model.Weather;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {

    //add your api key here
    private static final String API_KEY = "5bca776f735e450785d80355231611";

    //add the base api url here
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json?key=";

    private final RestTemplate restTemplate;
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using rest template, get the weather details of a city
    public Weather getWeather(String city) {

        String url = API_URL + API_KEY + "&q="+city +"&aqi=no";
        return restTemplate.getForObject(url,Weather.class);

    }



}
