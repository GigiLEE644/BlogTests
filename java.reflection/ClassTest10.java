public class ClassTest10 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<?> clazz = Person.class;

        Person p = (Person) clazz.newInstance();

        p.name = "tom";
        p.age = 18;

        System.out.println(p);
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