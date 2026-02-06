import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest54 {
    public static void main(String[] args) {
        Employee[] es = {
                new Employee("tom", 18, 10000),
                new Employee("jerry", 16, 10000),
                new Employee("spike", 28, 9000),
                new Employee("tyke", 6, 1000),
                new Employee("tuffy", 3, 100),
                new Employee("topsy", 3, 100),
        };

        Stream<Employee> s = Stream.of(es);

        Map<Integer, Map<Integer, List<Employee>>> m = s
                .collect(Collectors.groupingBy(e -> e.salary, Collectors.groupingBy(e -> e.age)));

        for (Map.Entry<Integer, Map<Integer, List<Employee>>> g : m.entrySet()) {
            System.out.println(g.getKey());
            System.out.println(g.getValue());
            System.out.println();
        }
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
/**
 * Output:
    10000
    {16=[Employee [name=jerry, age=16, salary=10000]], 18=[Employee [name=tom, age=18, salary=10000]]}

    100
    {3=[Employee [name=tuffy, age=3, salary=100], Employee [name=topsy, age=3, salary=100]]}

    1000
    {6=[Employee [name=tyke, age=6, salary=1000]]}

    9000
    {28=[Employee [name=spike, age=28, salary=9000]]}
 */