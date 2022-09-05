public class ThreadExceptionHandling2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            throw new RuntimeException("exception in runnable");
        };

        Thread t = new Thread(r);

        t.setUncaughtExceptionHandler((Thread tt, Throwable e) -> {
            System.out.println("Exception caught in thread " + tt.getName() + " : " + e.getMessage());
        });

        t.start();

        t.join();
    }
}
