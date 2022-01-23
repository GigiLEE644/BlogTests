public class InitializationTest3 {
    public static void main(String[] args) {
        System.out.println("B in Son = " + Son.B);
    }

    private static class Father {
        public static int A;
        static {
            A = 1;
            System.out.println("In static block of Father");
        }
    }

    private static class Son extends Father {
        public static int B;
        static {
            B = 2;
            System.out.println("In static block of Son");
            System.out.println("A in Father = " + A);
        }
    }
}
