import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest17 {
    public static void main(String[] args)
            throws SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            IllegalAccessException {
        System.setSecurityManager(new SecurityManager());

        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Method method = clazz.getDeclaredMethod("speak", String.class);

        method.setAccessible(true);

        method.invoke(p, "hello");
    }
}

class Person {
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

    private void speak(String words) {
        System.out.println(this + " : " + words);
    }
}