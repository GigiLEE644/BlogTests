import java.lang.reflect.Field;

public class ExceptionTest5 {
    public static void main(String[] args) {
        Person p = new Person("tom", 18);

        System.out.println(p);
        System.out.println();

        Class<?> clazz = p.getClass();

        Field name = null;

        try {
            name = clazz.getDeclaredField("nam");
        } catch (NoSuchFieldException | SecurityException e) {
            System.out.println("Exception found when getting declared field");
            System.out.println();
            e.printStackTrace();
        }

        System.out.println();

        try {
            System.out.println("name = " + name.get(p));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Exception found when getting name");
            System.out.println();
            e.printStackTrace();
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
