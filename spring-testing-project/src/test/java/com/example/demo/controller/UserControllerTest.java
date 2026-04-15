package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@Import(com.example.demo.config.SecurityConfig.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService service;

    // ❌ No authentication
    @Test
    void shouldReturnUnauthorized() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isUnauthorized());
    }

    // ❌ Wrong role
    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldReturnForbiddenForWrongRole() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isForbidden());
    }

    // ✅ Correct role
    @Test
    @WithMockUser(roles = "USER")
    void shouldReturnUser() throws Exception {

        User user = new User();
        user.setName("john");

        when(service.getUser(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("john"));
    }
}