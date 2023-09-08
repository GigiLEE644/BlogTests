import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest21 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Method method = clazz.getDeclaredMethod("toString", null);

        Greeting greeting = method.getDeclaredAnnotation(Greeting.class);

        System.out.println(method.invoke(p, null));
        System.out.println(greeting.value());
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        @Greeting("hello, how are you?")
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    private static @interface Greeting {
        public String value();
    }
}