//package com.stackroute.resttemplate.commander.test;
//import com.stackroute.resttemplate.controller.WeatherController;
//import com.stackroute.resttemplate.model.Weather;
//import com.stackroute.resttemplate.model.Location;
//import com.stackroute.resttemplate.model.Current;
//import com.stackroute.resttemplate.service.WeatherService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class WeatherControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private WeatherService weatherService;
//
//    @InjectMocks
//    private WeatherController weatherController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
//    }
//
//    @Test
//    public void testGetWeather_Success() throws Exception {
//        // Given
//        String city = "Delhi";
//        Weather mockWeather = new Weather();
////        Location mockLocation = new Location();
////        Current mockCurrent = new Current();
////
////        Location location = new Location();
////        location.setName("London");
////        location.setRegion("City of London, Greater London");
////        location.setCountry("United Kingdom");
////        mockWeather.setLocation(location);
////        Current current = new Current();
////
////        mockWeather.setCurrent(current);
//
//        // When
//        mockWeather = weatherService.getWeather(city);
//        assertNotNull(mockWeather);
//        assertEquals(city, mockWeather.getLocation().getName());
////        when(weatherService.getWeather(city)).thenReturn(mockWeather);
////        current.setTemp_c(mockWeather.getCurrent().getTemp_c());
//        // Then
////        mockMvc.perform(MockMvcRequestBuilders.get("/weather/{city}", city))
////                .andExpect(status().isOk())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(content().json("{\n" +
////                        "    \"location\": {\n" +
////                        "        \"name\": \"London\",\n" +
////                        "        \"region\": \"City of London, Greater London\",\n" +
////                        "        \"country\": \"United Kingdom\"\n" +
////                        "    },\n" +
////                        "    \"current\": {\n" +
////                        "        \"temp_c\": \"7.0\"\n" +
////                        "    }\n" +
////                        "}"));
//    }
//
//}
