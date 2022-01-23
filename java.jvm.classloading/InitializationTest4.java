public class InitializationTest4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 : A's ID = " + A.ID);
        });
        t1.setName("t1");

        Thread t2 = new Thread(() -> {
            System.out.println("t2 : B's ID = " + B.ID);
        });
        t2.setName("t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static class A {
        public static int ID = 1;
        static {
            System.out.println("A : B's ID = " + B.ID);
        }
    }

    private static class B {
        public static int ID = 2;
        static {
            System.out.println("B : A's ID = " + A.ID);
        }
    }
}
