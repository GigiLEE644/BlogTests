import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest20 {
    public static void main(String[] args) {
        Person p1 = new Person("tom");
        Person p2 = new Person("jerry");

        List<Person> g1 = new ArrayList<>();

        g1.add(p1);
        g1.add(p2);

        Person p3 = new Person("spike");
        Person p4 = new Person("tyke");

        List<Person> g2 = new ArrayList<>();

        g2.add(p3);
        g2.add(p4);

        List<List<Person>> g = new ArrayList<>();

        g.add(g1);
        g.add(g2);

        // map
        Stream<List<Person>> ss = g.stream().map(group -> group);

        ss.forEach(System.out::println);

        System.out.println();

        // flatMap
        Stream<Person> s = g.stream().flatMap(group -> group.stream());

        s.forEach(System.out::println);
    }

    private static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + "]";
        }
    }
}
