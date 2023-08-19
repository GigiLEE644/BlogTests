import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest12 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Method method = clazz.getMethod("speak", String.class);

        method.invoke(p, "hello world");
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

        public void speak(String words) {
            System.out.println(this + " : " + words);
        }
    }
}
