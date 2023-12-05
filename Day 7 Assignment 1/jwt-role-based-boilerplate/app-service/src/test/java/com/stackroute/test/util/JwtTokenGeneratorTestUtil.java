package com.stackroute.test.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenGeneratorTestUtil {
    TestUser user = new TestUser("john@email.com", "john@123", Role.ADMIN);

    public Map<String, String> generateToken(TestUser user) {
        //creates a new HashMap called userdata, which will be used to store
        // the user data that will be included in the token.
        Map<String, Object> userdata = new HashMap<>();
        //add properties into userdata
        userdata.put("id", user.getId());
        userdata.put("password", user.getPassword());
        userdata.put("role", user.getRole());
        String jwtToken = "";
        jwtToken = Jwts.builder().setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, String> jwtTokenMap = new HashMap<>();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("message", "Login Successful");
        return jwtTokenMap;
    }

}
