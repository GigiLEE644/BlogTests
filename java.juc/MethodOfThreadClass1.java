public class MethodOfThreadClass1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                long start = System.currentTimeMillis();
                Thread.sleep(3000);
                long end = System.currentTimeMillis();
                System.out.println(
                        Thread.currentThread().getName() + " has sleeped for "
                                + (end - start) + " milliseconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t = new Thread(r);
        t.start();
        t.join();
    }
}
