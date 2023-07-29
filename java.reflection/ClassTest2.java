import java.lang.reflect.Field;

public class ClassTest2 {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Person p = new Person("tom", 18);
        System.out.println(p);

        Class<Person> clazz = Person.class;

        Field nameField = clazz.getDeclaredField("name");
        String name = (String) nameField.get(p);

        Field ageField = clazz.getDeclaredField("age");
        int age = (int) ageField.get(p);

        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
