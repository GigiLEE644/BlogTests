public class ThreadCreation1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread t = new Thread(r, "Thread1");
        t.start();
        t.join();
    }
}
