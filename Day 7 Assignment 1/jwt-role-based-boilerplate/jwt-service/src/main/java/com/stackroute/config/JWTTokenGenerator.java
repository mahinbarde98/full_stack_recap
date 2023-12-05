package com.stackroute.config;

import java.util.Map;

import com.stackroute.domain.User;
import com.stackroute.exception.UserNotFoundException;
import jakarta.servlet.ServletException;

public interface JWTTokenGenerator {

    Map<String, String> generateToken(User user) throws ServletException, UserNotFoundException;
}
