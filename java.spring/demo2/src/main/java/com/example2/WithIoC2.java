package com.example2;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class WithIoC2 {
    public static void main(String[] args) {
        StaticApplicationContext context = new StaticApplicationContext();

        RootBeanDefinition userRepositoryDef = new RootBeanDefinition(UserRepository.class);

        context.registerBeanDefinition("userRepository", userRepositoryDef);

        RootBeanDefinition userServiceDef = new RootBeanDefinition(UserService.class);

        userServiceDef.getConstructorArgumentValues().addIndexedArgumentValue(0, context.getBean("userRepository"));

        context.registerBeanDefinition("userService", userServiceDef);

        UserService userService = context.getBean(UserService.class);

        userService.addUser("Tom");
        userService.addUser("Jerry");

        context.close();
    }

    private static class UserService {
        private final UserRepository repo;

        public UserService(UserRepository repo) {
            this.repo = repo;
        }

        public void addUser(String name) {
            this.repo.save(name);
        }
    }

    private static class UserRepository {
        public void save(String name) {
            System.out.println("User " + name + " saved to repository.");
        }
    }
}
