package com.stackroute.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("default")
public class DefaultProfileTest{


    @Value("${message}")
    String message;


    @Test
    public void testDevSpecificBehavior() {
        assert "This is default blog".equals(message);
    }
}
