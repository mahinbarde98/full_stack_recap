package com.stackroute.aggregator.portalservice.test.controller;

import com.stackroute.aggregator.portalservice.controller.PortalController;
import com.stackroute.aggregator.portalservice.domain.Address;
import com.stackroute.aggregator.portalservice.domain.Customer;
import com.stackroute.aggregator.portalservice.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PortalControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PortalController portalController;

    @Test
    void testGetUserDetails_Success() {
        long customerId = 123;
        Customer mockCustomer = new Customer(); // Create a mock Customer object
        Address mockAddress = new Address(); // Create a mock Address object
        User expectedUser = new User();
        expectedUser.setCustomer(mockCustomer);
        expectedUser.setAddress(mockAddress);

        when(restTemplate.getForObject("http://localhost:8060/customer/" + customerId, Customer.class))
                .thenReturn(mockCustomer);
        when(restTemplate.getForObject("http://localhost:8070/address/" + customerId, Address.class))
                .thenReturn(mockAddress);

        ResponseEntity<User> responseEntity = portalController.getUserDetails(customerId);

        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        assertEquals(expectedUser, responseEntity.getBody());

        verify(restTemplate, times(1)).getForObject("http://localhost:8060/customer/" + customerId, Customer.class);
        verify(restTemplate, times(1)).getForObject("http://localhost:8070/address/" + customerId, Address.class);
    }
}
