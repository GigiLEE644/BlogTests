import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest7 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class<?> clazz = Person.class;
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);

        System.out.println("constructor's name = " + constructor.getName());

        Class<?>[] parameters = constructor.getParameterTypes();

        for (int i = 0; i < parameters.length; i++) {
            Class<?> parameter = parameters[i];
            System.out.println("constructor's parameter " + (i + 1) + " = " + parameter.getName());
        }

        Person p = (Person) constructor.newInstance("tom", 18);
        System.out.println(p);
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
