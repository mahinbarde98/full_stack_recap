package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Priyanshu Singh
 */

@RestController
public class Controller {

    // Inject the value of the "message" property from the application.properties file
    @Value("${message}")
    String message;

    /**
     * Get the value of the "message" property.
     * @return The message retrieved from the application.properties file.
     */
    @GetMapping("/message")
    public String getMessage(){
        return  message;
    }
    
}
