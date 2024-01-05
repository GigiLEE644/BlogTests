import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Java8NewFeaturesTest4 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("tom", 18, "cat"));
        users.add(new User("jerry", 16, "mouse"));
        users.add(new User("butch", 18, "cat"));
        users.add(new User("Toodles Galore", 16, "cat"));
        users.add(new User("spike", 21, "dog"));
        users.add(new User("tyke", 6, "dog"));
        users.add(new User("tuffy", 3, "mouse"));
        users.add(new User("topsy", 3, "dog"));

        Predicate<User> dog = (u -> u.role == "dog");
        Predicate<User> cat = (u -> u.role == "cat");
        Predicate<User> gt10 = (u -> u.age > 10);

        List<User> filtered = filter(users, gt10.and(cat.or(dog).negate()));

        display(filtered);
    }

    private static void display(List<User> filtered) {
        for (User user : filtered) {
            System.out.println(user);
        }
        System.out.println();
    }

    private static List<User> filter(List<User> users, Predicate<User> p) {
        List<User> filtered = new ArrayList<>();

        for (User user : users) {
            if (p.test(user)) {
                filtered.add(user);
            }
        }
        return filtered;
    }

    private static class User {
        private String name;
        private int age;
        private String role;

        public User(String name, int age, String role) {
            this.name = name;
            this.age = age;
            this.role = role;
        }

        @Override
        public String toString() {
            return "User [name=" + name + ", age=" + age + ", role=" + role + "]";
        }
    }
}
