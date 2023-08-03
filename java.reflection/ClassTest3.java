import java.util.ArrayList;
import java.util.List;

public class ClassTest3 {
    public static void main(String[] args) {
        List<String> hierarchy = new ArrayList<>();

        Class<?> child = Apple.class;

        hierarchy.add(child.getName());

        Class<?> parent = child.getSuperclass();

        while (parent != null) {
            hierarchy.add(parent.getName());

            child = parent;
            parent = parent.getSuperclass();
        }

        hierarchy.forEach(System.out::println);
    }

    private static class Food {

    }

    private static class Fruit extends Food {

    }

    private static class Apple extends Fruit {

    }
}
