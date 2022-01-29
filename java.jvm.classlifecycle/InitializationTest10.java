public class InitializationTest10 {
    public static void main(String[] args) {
        System.out.println(Son.ID);
    }

    private static class Father {
        static {
            System.out.println("Father has been initialized!");
        }
    }

    private static class Son extends Father {
        public static int ID = 1;

        static {
            System.out.println("Son has been initialized!");
        }
    }
}
