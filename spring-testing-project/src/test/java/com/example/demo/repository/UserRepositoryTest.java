package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldSaveAndFindUser() {
        User user = new User();
        user.setName("john");
        user.setEmail("john@mail.com");

        User saved = userRepository.save(user);

        Optional<User> found = userRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("john");
    }

    @Test
    void shouldFindByEmail() {
        User user = new User();
        user.setName("john");
        user.setEmail("john@mail.com");

        userRepository.save(user);

        Optional<User> found = userRepository.findByEmail("john@mail.com");

        assertThat(found).isPresent();
    }
}