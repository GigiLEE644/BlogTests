public class MethodOfThreadClass4 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
            System.out.println(Thread.currentThread().getName() + " stops running");
        };

        Thread t = new Thread(r);

        t.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();

        t.join();
    }
}
