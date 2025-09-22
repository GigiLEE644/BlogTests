public class Java25NewFeaturesTest4 {
    private static class Person {
        String name;
        int age;

        Person() {
            this.name = "Unknown";
            this.age = 0;
            super();
            System.out.println("new born person " + toString());
        }

        Person(String name, int age) {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150");
            }
            this();
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    void main() {
        Person p1 = new Person();

        System.out.println(p1);

        Person p2 = new Person("Alice", 30);

        System.out.println(p2);
    }
}
/*
 * Output: new born person Person{name='Unknown', age=0}
 *         Person{name='Unknown', age=0}
 *         new born person Person{name='Unknown', age=0}
 *         Person{name='Alice', age=30}
 */