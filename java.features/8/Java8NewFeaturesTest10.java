import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Java8NewFeaturesTest10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("tom");
        names.add("jerry");
        names.add("spike");
        names.add("tyke");

        Function<String, User> f = User::new;

        for (String name : names) {
            User user = f.apply(name);
            System.out.println(user);
        }
    }

    private static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [name=" + name + "]";
        }
    }
}
