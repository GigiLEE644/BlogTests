public class InitializationTest8 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("InitializationTest8$A");
    }

    private static class A {
        static {
            System.out.println("A has been initialized!");
        }
    }
}
