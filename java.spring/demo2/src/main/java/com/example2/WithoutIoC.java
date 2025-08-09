package com.example2;

public class WithoutIoC {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        userService.addUser("Tom");
        userService.addUser("Jerry");
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
