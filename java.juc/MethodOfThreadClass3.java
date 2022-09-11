public class MethodOfThreadClass3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("This line will not be printed beacause the interruption of thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(Thread.currentThread().getName() + " has been interrupted !", e);
            }
        };

        Thread t = new Thread(r);

        t.start();

        t.interrupt();

        t.join();
    }
}
