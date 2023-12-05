package com.stackroute.test.controller;

import com.stackroute.test.util.JwtTokenGeneratorTestUtil;
import com.stackroute.test.util.Role;
import com.stackroute.test.util.TestUser;
import com.stackroute.controller.ServiceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ServiceControllerTest {
    private MockMvc mockMvc;
    private TestUser user;
    @Autowired
    private ServiceController serviceController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(serviceController).build();
        user = new TestUser("meghna@email.com", "meghna@123", Role.USER);
    }

    @Test
    void givenGetMappingUrlThenShouldReturnStringMessage() throws Exception {
        mockMvc.perform(get("/api/v1/User")
                .header("Authorization", "Bearer " + new JwtTokenGeneratorTestUtil().generateToken(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("This is User Data!"));


    }
}