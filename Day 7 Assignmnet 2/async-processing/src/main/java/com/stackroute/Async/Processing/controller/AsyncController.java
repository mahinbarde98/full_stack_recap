package com.stackroute.Async.Processing.controller;

import com.stackroute.Async.Processing.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController
/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping("/api/v1")
public class AsyncController {

    private final AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/async-task")
    public String triggerAsyncTask() {
        //Call performAsyncTask() method of AsyncServiceImpl class

        asyncService.performAsyncTask();

        return "Async task started.";

    }
}
