import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ClassTest19 {
    public static void main(String[] args) {
        Person p = new Person("tom", 18);

        System.out.println(p);

        Class<?> clazz = p.getClass();
        toStringable annotation = clazz.getAnnotation(toStringable.class);

        System.out.println(
                "Person [" + annotation.name() + "=" + p.name + ", " + annotation.age() + "=" + p.age + "]");
    }

    @toStringable(name = "personName", age = "personAge")
    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    private static @interface toStringable {
        public String name();

        public String age();
    }
}
