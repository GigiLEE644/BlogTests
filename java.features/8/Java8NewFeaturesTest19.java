import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest19 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("tom", "jerry");

        names.forEach(System.out::println);

        System.out.println();

        Stream<Person> ps = names.stream().map(Person::new);

        ps.forEach(System.out::println);
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
