import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest11 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> clazz = Person.class;

        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);

        Person p = (Person) constructor.newInstance("tom", 18);

        System.out.println(p);
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
