import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest13 {
    public static void main(String[] args)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Method method = clazz.getMethod("speak", String.class);

        try {
            method.invoke(p, "Such a long fucking day!");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            System.out.println(cause.getMessage());
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

        public void speak(String words) {
            if (words != null && words.contains("fuck")) {
                throw new IllegalStateException(this + " is saying some dirty words which is not allowed !!!");
            }
            System.out.println(this + " : " + words);
        }
    }
}
