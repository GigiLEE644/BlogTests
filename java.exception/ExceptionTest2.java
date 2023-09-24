import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ExceptionTest2 {
    public static void main(String[] args)
            throws SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, NoSuchFieldException {
        Person p = new Person("tom", 18);

        System.out.println(p);

        Class<?> clazz = p.getClass();

        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");

        System.out.println("name = " + name.get(p));
        System.out.println("age = " + age.get(p));
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
