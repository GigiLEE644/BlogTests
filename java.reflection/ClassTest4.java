import java.lang.reflect.Modifier;

public class ClassTest4 {
    public static void main(String[] args) {
        int mod = Person.class.getModifiers();

        System.out.println("isPrivate = " + Modifier.isPrivate(mod));
        System.out.println("isStatic = " + Modifier.isStatic(mod));
        System.out.println("isFinal = " + Modifier.isFinal(mod));
    }

    private static final class Person {
    }
}
