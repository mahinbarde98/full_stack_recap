package com.stackroute.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author Priyanshu Singh
 */

@SpringBootTest
@ActiveProfiles("test")
public class TestProfileTest {


    @Value("${message}")
    String message;


    @Test
    public void testDevSpecificBehavior() {
        assert "This is test blog".equals(message);

    }
}
