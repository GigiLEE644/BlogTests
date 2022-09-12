public class MethodOfThreadClass5 {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread t1 = new Thread(r1, "t1");

        Runnable r2 = () -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        };

        Thread t2 = new Thread(r2, "t2");

        t2.start();
        t1.start();
    }
}
