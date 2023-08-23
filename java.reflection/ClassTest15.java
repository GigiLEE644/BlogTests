import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest15 {
    public static void main(String[] args)
            throws SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            IllegalAccessException {
        Employee e = new Employee("tom", 18, 1);

        Class<?> clazz = e.getClass();

        Method method = null;

        try {
            method = clazz.getDeclaredMethod("speak", String.class);
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }

        method = clazz.getDeclaredMethod("work", null);

        try {
            method.invoke(e, "hello world");
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }

        method.setAccessible(true);
        method.invoke(e, null);
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

class Employee extends Person {
    private int id;

    public Employee(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + "] " + super.toString();
    }

    private void work() {
        System.out.println(this + " is now working...");
    }
}