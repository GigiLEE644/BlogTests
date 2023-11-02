public class ExceptionTest19 {

    private static void newObject(int n) {
        long l = System.nanoTime();
        for (int i = 0; i < n; i++) {
            new Object();
        }
        System.out.println("Create Objects : " + (System.nanoTime() - l));
    }

    private static void newException(int n) {
        long l = System.nanoTime();
        for (int i = 0; i < n; i++) {
            new Exception();
        }
        System.out.println("Create Exception Objects : " + (System.nanoTime() - l));
    }

    private static void catchException(int n) {
        long l = System.nanoTime();
        for (int i = 0; i < n; i++) {
            try {
                throw new Exception();
            } catch (Exception e) {

            }
        }
        System.out.println("Create Throw and Catch Exception Objects : " + (System.nanoTime() - l));
    }

    public static void main(String[] args) {
        int n = 10000;
        newObject(n);
        newException(n);
        catchException(n);
    }
}