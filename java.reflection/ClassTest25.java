import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ClassTest25 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Field name = clazz.getDeclaredField("name");

        Alias alias = name.getDeclaredAnnotation(Alias.class);
        System.out.println(alias.value() + " = " + name.get(p));

        Field age = clazz.getDeclaredField("age");

        alias = age.getDeclaredAnnotation(Alias.class);
        System.out.println(alias.value() + " = " + age.get(p));
    }

    private static class Person {
        @Alias("person_name")
        private String name;
        @Alias("person_age")
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

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    private static @interface Alias {
        public String value();
    }
}
