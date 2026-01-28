import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest22 {
    public static void main(String[] args) {
        Person p1 = new Person("tom", 18);
        Person p2 = new Person("jerry", 16);
        Person p3 = new Person("spike", 26);
        Person p4 = new Person("tyke", 6);
        Person p5 = new Person("tom", 18);
        Person p6 = new Person("jerry", 16);

        List<Person> ps = new ArrayList<>();

        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);
        ps.add(p6);

        Stream<Person> s = ps.stream().distinct();

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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + age;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (age != other.age)
                return false;
            return true;
        }

    }
}
/**
 * Output:
        Person [name=tom, age=18]
        Person [name=jerry, age=16]
        Person [name=spike, age=26]
        Person [name=tyke, age=6]
 */