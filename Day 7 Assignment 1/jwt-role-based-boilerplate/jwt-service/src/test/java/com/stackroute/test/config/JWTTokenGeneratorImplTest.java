package com.stackroute.test.config;

import com.stackroute.config.JWTTokenGeneratorImpl;
import com.stackroute.domain.Role;
import com.stackroute.domain.User;
import com.stackroute.exception.UserNotFoundException;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JWTTokenGeneratorImplTest {
    private User user;

    @Autowired
    private JWTTokenGeneratorImpl jwtTokenGenerator;
    private Map<String, String> tokenMap;

    @BeforeEach
    public void setup() {
        user = new User("Andy", "andy@email.com", Role.ADMIN);
        tokenMap = new HashMap<>();
    }

    @Test
    void givenAUserThenCallToGenerateTokenShouldReturnNotNull() throws ServletException, UserNotFoundException {
        /*Act*/
        tokenMap = jwtTokenGenerator.generateToken(user);
        /*Assert*/
        assertNotNull(tokenMap);
    }

    @Test
    void givenAUserThenShouldReturnExpectedKeysInMap() throws ServletException, UserNotFoundException {
        /*ACt*/
        tokenMap = jwtTokenGenerator.generateToken(user);
        /*Assert*/
        assertNotNull(tokenMap.containsKey("token"));
        assertNotNull(tokenMap.containsKey("message"));
    }

    @Test
    void givenAUserThenShouldReturnExpectedTokenInMap() throws ServletException, UserNotFoundException {
        /*ACt*/
        tokenMap = jwtTokenGenerator.generateToken(user);
        /*Assert*/
        assertThat(tokenMap.get("token").length()).isGreaterThan(20);
    }

    @Test
    void givenAUserThenShouldReturnExpectedClaimInMap() throws ServletException, UserNotFoundException {
        /*ACt*/
        tokenMap = jwtTokenGenerator.generateToken(user);
        /*Assert*/
        assertThat(tokenMap.get("message")).isEqualTo("Login Successful");
    }
}