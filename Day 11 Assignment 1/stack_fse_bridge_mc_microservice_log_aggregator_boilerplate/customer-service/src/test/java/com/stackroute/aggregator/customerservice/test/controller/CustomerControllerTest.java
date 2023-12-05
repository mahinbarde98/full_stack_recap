package com.stackroute.aggregator.customerservice.test.controller;

import com.stackroute.aggregator.customerservice.controller.CustomerController;
import com.stackroute.aggregator.customerservice.domain.Customer;
import com.stackroute.aggregator.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void testGetCustomer_Success() {
        int customerId = 123;
        Customer mockCustomer = new Customer(); // Create a mock Customer object

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        ResponseEntity<Customer> responseEntity = customerController.getCustomer(customerId);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(mockCustomer, responseEntity.getBody());

        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    void testGetCustomer_NoContent() {
        int customerId = 456;

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        ResponseEntity<Customer> responseEntity = customerController.getCustomer(customerId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());

        verify(customerRepository, times(1)).findById(customerId);
    }
}
