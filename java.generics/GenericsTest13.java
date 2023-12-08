import java.util.ArrayList;
import java.util.List;

public class GenericsTest13 {
    public static void main(String[] args) {
        List<Parent> parents = new ArrayList<>();

        parents.add(new Parent());

        display(parents);
    }

    private static class Parent {

    }

    private static class Child extends Parent {

    }

    private static void display(List<Child> objs) {
        System.out.println("Child List :");
        objs.forEach(System.out::println);
    }
}
