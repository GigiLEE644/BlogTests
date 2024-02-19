import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Java8NewFeaturesTest56 {
    public static void main(String[] args) {
        Employee[] es = {
                new Employee("tom", 18, 10000),
                new Employee("jerry", 16, 10000),
                new Employee("spike", 28, 9000),
                new Employee("tyke", 6, 1000),
                new Employee("tuffy", 3, 100),
                new Employee("topsy", 3, 100),
        };

        Collector<Employee, StringJoiner, String> c = Collector.of(
                () -> {
                    System.out.println("supplier");
                    System.out.println();
                    return new StringJoiner(",");
                },
                (sj, e) -> {
                    System.out.println("accumulator");
                    System.out.println(sj.toString());
                    System.out.println(e);
                    System.out.println();
                    sj.add(e.name);
                },
                (sj1, sj2) -> {
                    System.out.println("combiner");
                    System.out.println(sj1.toString());
                    System.out.println(sj2.toString());
                    System.out.println();

                    return sj1.merge(sj2);
                },
                (sj) -> {
                    System.out.println("finisher");
                    System.out.println(sj);
                    System.out.println();

                    return sj.toString();
                });

        System.out.println(Stream.of(es).collect(c));
    }

    private static class Employee {
        private String name;
        private int age;
        private int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
        }
    }
}
