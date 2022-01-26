public class InitializationTest6 {
    public static void main(String[] args) {
        System.out.println(A.ID);
    }

    private static class A {
        public static int ID = 1;
        static {
            System.out.println("A has been initialized!");
        }
    }
}
