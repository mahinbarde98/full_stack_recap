package com.stackroute.aggregator.addressservice.test.controller;

import com.stackroute.aggregator.addressservice.controller.AddressController;
import com.stackroute.aggregator.addressservice.domain.Address;
import com.stackroute.aggregator.addressservice.repsoitory.AddressRespository;
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
public class AddressControllerTest {

    @Mock
    private AddressRespository addressRespository;

    @InjectMocks
    private AddressController addressController;

    @Test
    void testGetAddress_Success() {
        int customerId = 123;
        Address mockAddress = new Address(); // Create a mock Address object

        when(addressRespository.findById(customerId)).thenReturn(Optional.of(mockAddress));

        ResponseEntity<Address> responseEntity = addressController.getAddress(customerId);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(mockAddress, responseEntity.getBody());

        verify(addressRespository, times(1)).findById(customerId);
    }

    @Test
    void testGetAddress_NoContent() {
        int customerId = 456;

        when(addressRespository.findById(customerId)).thenReturn(Optional.empty());

        ResponseEntity<Address> responseEntity = addressController.getAddress(customerId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());

        verify(addressRespository, times(1)).findById(customerId);
    }
}
