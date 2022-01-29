public class InitializationTest11 {
    public static void main(String[] args) {
        System.out.println(A.ID);
    }

    private static interface I {
        Thread t = new Thread() {
            {
                System.out.println("t has been initialized, so I must have been initialized!");
            }
        };

        default void greeting(){

        }
    }

    private static class A implements I {
        public static int ID = 1;
        static {
            System.out.println("A has been initialized!");
        }
    }
}
