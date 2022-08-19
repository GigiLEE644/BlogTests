public class OrdernessProblemExample {
    private static int x, y, a, b;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Round " + (++i) + " : x = " + x + " y = " + y);

            if (x == 0 && y == 0) {
                break;
            }
        }
    }
}
