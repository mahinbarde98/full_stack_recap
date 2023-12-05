package com.stackroute.resttemplate.test;

import com.stackroute.resttemplate.model.Weather;
import com.stackroute.resttemplate.service.WeatherService;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class WeatherServiceTest {

    @Test
    public void testGetWeather_Success() {
        // Given
        RestTemplate restTemplate = new RestTemplate();
        WeatherService weatherService = new WeatherService(restTemplate);
        String city = "London";

        // When
        Weather weather = weatherService.getWeather(city);

        // Then
        assertNotNull(weather);
        assertEquals(city, weather.getLocation().getName());
    }

    @Test
    public void testGetWeather_Success_Delhi() {
        // Given
        RestTemplate restTemplate = new RestTemplate();
        WeatherService weatherService = new WeatherService(restTemplate);
        String city = "Delhi";

        // When
        Weather weather = weatherService.getWeather(city);

        // Then
        assertNotNull(weather);
        assertEquals(city, weather.getLocation().getName());
    }

    @Test
    public void testGetWeather_Chicago() {
        // Given
        RestTemplate restTemplate = new RestTemplate();
        WeatherService weatherService = new WeatherService(restTemplate);
        String city = "Chicago";

        // When
        Weather weather = weatherService.getWeather(city);

        // Then
        assertNotNull(weather);
        assertEquals(city, weather.getLocation().getName());
    }

    @Test
    public void testGetWeather_APIError() {
        // Given
        RestTemplate restTemplate = new RestTemplate();
        WeatherService weatherService = new WeatherService(restTemplate);
        String city = "London";

        // When
        Weather weather = weatherService.getWeather(city);

        // Then
        assertNotNull(weather);
    }
}
