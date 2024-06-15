import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Java11NewFeaturesTest4 {

    public static void main(String[] args) {
        List<Person> users = new ArrayList<>();

        users.add(new Person("tom", 18));
        users.add(new Person("jerry", 16));
        users.add(new Person("spike", 28));

        users.stream().filter(p -> !p.isAdult()).forEach(System.out::println);

        System.out.println();

        users.stream().filter(Predicate.not(Person::isAdult)).forEach(System.out::println);
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        boolean isAdult() {
            return this.age > 18;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}