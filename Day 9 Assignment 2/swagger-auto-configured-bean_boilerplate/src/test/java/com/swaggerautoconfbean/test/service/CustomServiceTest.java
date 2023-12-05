package com.swaggerautoconfbean.test.service;

import com.stackroute.swaggerautoconfbean.service.CustomService;
import com.stackroute.swaggerautoconfbean.service.CustomServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomServiceTest {
    @Test
    public void customLogicShouldReturnCustomMessage() {
        // Arrange
        CustomService customService = new CustomServiceImpl();

        // Act
        String result = customService.customLogic();

        // Assert
        assertEquals("Custom logic executed by CustomService", result, "Custom logic message should match");
    }
}
