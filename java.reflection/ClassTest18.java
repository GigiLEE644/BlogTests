import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest18 {
    public static void main(String[] args)
            throws SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            IllegalAccessException {
        System.setProperty("java.security.policy",
                "file:/home/yan/github/BlogTests/java.reflection/my_security.policy");
        System.setSecurityManager(new SecurityManager());

        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Method method = clazz.getDeclaredMethod("speak", String.class);

        method.setAccessible(true);

        method.invoke(p, "hello");
    }
}
