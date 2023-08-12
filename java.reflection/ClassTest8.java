import java.lang.reflect.Method;

public class ClassTest8 {
    public static void main(String[] args) {
        Person p = new Person("tom", 18);
        System.out.println(p);
        System.out.println();

        Class<?> clazz = p.getClass();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            System.out.println("method's name = " + method.getName());
            Class<?>[] parameters = method.getParameterTypes();
            for (int i = 0; i < parameters.length; i++) {
                System.out.println("method's parameter = " + parameters[i].getName());
            }
            System.out.println("method's return type = " + method.getReturnType());
            System.out.println();
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
