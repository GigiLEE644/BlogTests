import java.lang.reflect.InvocationTargetException;

public class ClassTest1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // From class
        Class<?> clazz = String.class;

        System.out.println(clazz);

        // From object
        clazz = "tom".getClass();

        System.out.println(clazz);

        // From fully qualified class name
        clazz = Class.forName("java.lang.String");

        System.out.println(clazz);
    }
}
