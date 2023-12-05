package com.stackroute.smartparkingapp.test.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.smartparkingapp.SmartParkingApplication;
import com.stackroute.smartparkingapp.controller.ParkingController;
import com.stackroute.smartparkingapp.model.Parking;
import com.stackroute.smartparkingapp.repo.ParkingRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SmartParkingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureTestDatabase
public class ParkingControllerTest {

    private Logger logger;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkingRepo parkingRepo;
    @MockBean
    private ModelMapper mapper;
    private Parking parking;
    private Parking parkingOne;
    private Parking parkingTwo;
    private List<Parking> parkingList;
    private static final String URL = "/api/v1/parking";
    private static final String AUTH_TOKEN = "authorization";

    @BeforeEach
    public void setUp() {

        logger = LoggerFactory.getLogger(ParkingController.class);


        parking = new Parking("Car", "128m*200m");
        parkingOne = new Parking("Cycle", "128m*200m");
        parkingTwo = new Parking("Motor Cycle", "20m*33m");
        parkingList = new ArrayList<>();
        parkingList.add(parkingOne);
        parkingList.add(parkingTwo);

    }

    @AfterEach()
    public void tearDown() {

        parking = null;
        parkingOne = null;
        parkingTwo = null;
        parkingList = null;
    }


    @Test
    @Transactional
    public void givenObjectWhenSaveOrUpdateTaskThenReturnObject() throws Exception {
        parkingRepo.save(parking);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URL)
                .accept(MediaType.APPLICATION_JSON).content(asJsonString(parking))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertNotNull(response.getContentAsString());
        assertNull(response.getErrorMessage());
        assertNotNull(parkingRepo.getOne(parking.getParkingId()));
        assertTrue(logger.isInfoEnabled());
        assertTrue(logger.isErrorEnabled());

    }

    @Test
    @Transactional
    public void givenObjectWhenUpdateParkingThenReturnObject() throws Exception {
        parkingRepo.save(parking);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URL)
                .accept(MediaType.APPLICATION_JSON).content(asJsonString(parking))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertNotNull(response.getContentAsString());
        assertNull(response.getErrorMessage());
        assertNotNull(parkingRepo.getOne(parking.getParkingId()));
        assertTrue(logger.isInfoEnabled());
        assertTrue(logger.isErrorEnabled());
    }

    @Test
    @Transactional
    public void givenObjectWhenDeleteParkingThenReturnObject() throws Exception {
        parkingRepo.save(parking);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URL)
                .accept(MediaType.APPLICATION_JSON).content(asJsonString(parking))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertNotNull(response.getContentAsString());
        assertNull(response.getErrorMessage());
        assertTrue(logger.isInfoEnabled());
        assertTrue(logger.isErrorEnabled());

    }

    @Test
    @Transactional
    public void givenObjectWhenGetParkingDetailsThenReturnList() throws Exception {
        parkingRepo.save(parking);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/parkings")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertNotNull(response.getContentAsString());
        assertNull(response.getErrorMessage());
        assertNotNull(parkingRepo.getOne(parking.getParkingId()));
        assertTrue(logger.isInfoEnabled());
        assertTrue(logger.isErrorEnabled());

    }
    private static String asJsonString(final Object obj) {
        String str = null;
        try {
            str = new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return str;
    }

}
