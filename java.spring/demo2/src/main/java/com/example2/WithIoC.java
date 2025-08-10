package com.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
public class WithIoC {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(WithIoC.class);

        UserService userService = context.getBean(UserService.class);

        userService.addUser("Tom");
        userService.addUser("Jerry");

        context.close();
    }

    @Service
    private static class UserService {
        private final UserRepository repo;

        public UserService(UserRepository repo) {
            this.repo = repo;
        }

        public void addUser(String name) {
            this.repo.save(name);
        }
    }

    @Component
    private static class UserRepository {
        public void save(String name) {
            System.out.println("User " + name + " saved to repository.");
        }
    }
}
