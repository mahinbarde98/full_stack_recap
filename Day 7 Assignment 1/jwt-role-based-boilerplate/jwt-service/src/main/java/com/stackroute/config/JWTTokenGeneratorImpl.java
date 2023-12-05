package com.stackroute.config;

import com.stackroute.domain.User;
import com.stackroute.exception.UserNotFoundException;
import com.stackroute.service.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * This class is implementing the JWTTokenGenerator interface. This class has to be annotated with
 * @Service annotation.
 * @Service indicates annotated class is a service
 * which hold business logic in the Service layer
 *
 * */
@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator {

    /**
     * To get the property values
     */
    @Value("${jwt.secret}")
    private String secret;

    @Value("${app.jwttoken.message}")
    private String message;

    private UserServiceImpl userService;

    @Autowired
    private JWTTokenGeneratorImpl(UserServiceImpl userService){
        this.userService =userService;
    }

    @Override
    public Map<String, String> generateToken(User user){
        String jwtToken = "";



        /*
         * Generate JWT token and store in String jwtToken
         */
        Map<String, String> jwtTokenMap = new HashMap<>();

       jwtToken= Jwts.builder()
                 .setSubject(user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3000000))
                .signWith(SignatureAlgorithm.HS256, "secret key")
                .compact();

        jwtTokenMap.put("message","Login Successful");
        jwtTokenMap.put("token",jwtToken);

        return jwtTokenMap;
    }
}
