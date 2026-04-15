package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repo;

    @InjectMocks
    UserService service;

    @Test
    void testGetUser() {
        User user = new User();
        user.setName("john");

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        assertEquals("john", service.getUser(1L).getName());
    }
}
