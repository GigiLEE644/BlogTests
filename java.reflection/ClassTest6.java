import java.lang.reflect.Field;

public class ClassTest6 {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Person p = new Person();
        p.name = "tom";
        p.age = 18;

        System.out.println(p);
        System.out.println();

        Class<?> clazz = p.getClass();
        for (Field field : clazz.getFields()) {
            System.out.println("Name = " + field.getName());
            System.out.println("Type = " + field.getType());
            Object value = field.get(p);
            System.out.println("Value = " + value);
            System.out.println();
        }
    }

    private static class Person {
        public String name;
        public int age;

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
