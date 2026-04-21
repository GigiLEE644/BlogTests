package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    @WithMockUser(roles = "USER")
    void shouldCreateUser() throws Exception {
        String json = """
                {
                    "name": "john",
                    "email": "john@mail.com"
                }
                """;

        User createdUser = new User();
        createdUser.setId(1L);
        createdUser.setName("john");
        createdUser.setEmail("john@mail.com");

        when(service.createUser(any(User.class))).thenReturn(createdUser);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("john"))
                .andExpect(jsonPath("$.email").value("john@mail.com"));
    }
}