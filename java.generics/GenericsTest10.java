public class GenericsTest10 {
    public static void main(String[] args) {
        Child child = new Child();
        display(child);
    }

    private static class Parent {

    }

    private static class Child extends Parent {

    }

    private static void display(Parent obj) {
        System.out.println("Parent : " + obj);
    }
}