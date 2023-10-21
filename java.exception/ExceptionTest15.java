public class ExceptionTest15 {
    public static void main(String[] args) {
        int x = checkReturn();
        System.out.println("x = " + x);
    }

    static int checkReturn() {
        int x = 0;
        try {
            // x = 1 but not return immediately
            return ++x;
        } finally {
            // x = 2 and return immediately
            return ++x;
        }
    }
}
