
package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getUser(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public User createUser(User user) {
        return repo.save(user);
    }
}
