import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest23 {
    public static void main(String[] args) {
        Person p1 = new Person("tom", 18);
        Person p2 = new Person("jerry", 16);
        Person p3 = new Person("spike", 26);
        Person p4 = new Person("tyke", 6);

        List<Person> ps = new ArrayList<>();

        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);

        Stream<Person> s = ps.stream().limit(2);

        s.forEach(System.out::println);

        System.out.println();

        s = ps.stream().limit(6);

        s.forEach(System.out::println);

        System.out.println();

        s = ps.stream().limit(0);

        s.forEach(System.out::println);
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
