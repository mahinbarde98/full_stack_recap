package com.swaggerautoconfbean.test.config;

import com.stackroute.swaggerautoconfbean.config.CustomDataSource;
import jakarta.activation.DataSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomDataSourceTest {
    @Test
    public void customDataSourceShouldNotBeNull() {
        // Arrange
        DataSource dataSource = (DataSource) new CustomDataSource();

        // Act and Assert
        assertNotNull(dataSource, "Custom DataSource should not be null");
    }
}
