import java.lang.reflect.InvocationTargetException;

public class GenericsTest23 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Person p = newInstanceOf(Person.class);
        p.name = "tom";
        p.age = 18;
        System.out.println(p);
    }

    private static <T> T newInstanceOf(Class<T> clazz) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // Cannot instantiate the type T
        // T o = new T();
        T obj = clazz.getDeclaredConstructor().newInstance();
        return obj;
    }

    private static class Person {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
