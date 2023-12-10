import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericsTest13 {
    public static void main(String[] args) {
        List<Person> ps = new ArrayList<>();

        ps.add(new Person(18, "tom"));
        ps.add(new Person(16, "jerry"));

        System.out.println(max(ps));

        List<Student> ss = new ArrayList<>();

        ss.add(new Student(18, "tom", 1));
        ss.add(new Student(16, "jerry", 2));

        System.out.println(max(ss));
    }

    private static class Person implements Comparable<Person>, Serializable {
        Integer age;
        String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age.compareTo(o.age);
        }

        @Override
        public String toString() {
            return "Person [age = " + age + ", name = " + name + "]";
        }
    }

    private static class Student extends Person {
        Integer id;

        public Student(Integer age, String name, Integer id) {
            super(age, name);
            this.id = id;
        }

        @Override
        public int compareTo(Person o) {
            if (o instanceof Student) {
                return this.id.compareTo(((Student) o).id);
            }
            return super.compareTo(o);
        }

        @Override
        public String toString() {
            return "Student [id = " + id + ", age = " + age + ", name = " + name + "]";
        }
    }

    private static <T extends Comparable<? super T> & Serializable> T max(List<T> elements) {
        T max = elements.get(0);

        for (int i = 0; i < elements.size(); i++) {
            T current = elements.get(i);

            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;
    }
}
