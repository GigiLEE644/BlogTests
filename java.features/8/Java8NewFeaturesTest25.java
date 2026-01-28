import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest25 {
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

        Stream<Person> s = ps.stream().sorted();

        s.forEach(System.out::println);

        System.out.println();

        s = ps.stream().sorted(Comparator.reverseOrder());

        s.forEach(System.out::println);

        System.out.println();

        s = ps.stream().sorted(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });

        s = ps.stream().sorted((person1, person2) -> person1.age - person2.age);

        s.forEach(System.out::println);
    }

    private static class Person implements Comparable<Person> {
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

        @Override
        public int compareTo(Person p) {
            return this.name.compareTo(p.name);
        }
    }
}
/**
 * Output:
        Person [name=jerry, age=16]
        Person [name=spike, age=26]
        Person [name=tom, age=18]
        Person [name=tyke, age=6]

        Person [name=tyke, age=6]
        Person [name=tom, age=18]
        Person [name=spike, age=26]
        Person [name=jerry, age=16]

        Person [name=tyke, age=6]
        Person [name=jerry, age=16]
        Person [name=tom, age=18]
        Person [name=spike, age=26]
 */