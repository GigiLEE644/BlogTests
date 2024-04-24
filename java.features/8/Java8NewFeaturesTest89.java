import java.util.Optional;

public class Java8NewFeaturesTest89 {
    public static void main(String[] args) {
        System.out.println("*********  Tom is >= 18 *********");
        Person p = new Person("tom", 18);

        traditionalWay(p);

        optionalWay(p);

        System.out.println();
        System.out.println("********* Jerry is < 18 *********");

        Person p2 = new Person("jerry", 16);

        traditionalWay(p2);

        optionalWay(p2);

        System.out.println();
        System.out.println("*********  No one here  *********");

        Person p3 = null;

        traditionalWay(p3);

        optionalWay(p3);
    }

    private static void optionalWay(Person person) {
        Optional.ofNullable(person).filter(p -> p.age >= 18).ifPresent(System.out::println);
    }

    private static void traditionalWay(Person person) {
        if (person != null && person.age >= 18) {
            System.out.println(person);
        }
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
