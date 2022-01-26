public class InitializationTest7 {
    public static void main(String[] args) {
        A.greeting();
    }

    private static class A {
        static {
            System.out.println("A has been initialized!");
        }

        public static void greeting() {
            System.out.println("hello this is A");
        }
    }
}
