package com.stackroute.customresponse.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    //return response entity with a hashmap containing message, status value and responseObject
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String,Object> map = new HashMap<>();
        map.put("message",message);
        map.put("status", status.value());
        map.put("responseObject", responseObj);


        return new ResponseEntity<Object>(map,status);
    }
}
