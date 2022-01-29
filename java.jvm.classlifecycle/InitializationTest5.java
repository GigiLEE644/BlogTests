public class InitializationTest5 {
    public static void main(String[] args) {
        A a = new A();
    }

    private static class A {
        static {
            System.out.println("A has been initialized!");
        }
    }
}
