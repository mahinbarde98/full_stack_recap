package com.stackroute.test.filter;

import com.stackroute.test.util.JwtTokenGeneratorTestUtil;
import com.stackroute.test.util.TestUser;
import com.stackroute.filter.JwtAdminFilter;
import com.stackroute.test.util.Role;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JwtFilterTest {

    private static final String TEST_URI = "/api/v1/Admin";

    JwtTokenGeneratorTestUtil jwtTokenGeneratorTestUtil = new JwtTokenGeneratorTestUtil();
    private JwtAdminFilter jwtFilter = new JwtAdminFilter();

    @Test
    public void testDoFilterInternalPositiveScenarioWhenTokenIsInHeader() throws ServletException, IOException {
        Map<String, String> tokenMap = jwtTokenGeneratorTestUtil.generateToken(new TestUser("john@email.com", "john@123", Role.ADMIN));
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer " + tokenMap.get("token"));
        request.setRequestURI(TEST_URI);
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain filterChain = new MockFilterChain();
        jwtFilter.doFilter(request, response, filterChain);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}