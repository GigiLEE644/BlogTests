import java.util.ArrayList;
import java.util.List;

public class GenericsTest12 {
    public static void main(String[] args) {
        List<Child> children = new ArrayList<>();
        children.add(new Child());

        display(children);
    }

    private static class Parent {

    }

    private static class Child extends Parent {

    }

    private static void display(List<? extends Parent> objs) {
        System.out.println("Parent List :");
        objs.forEach(System.out::println);
    }
}
