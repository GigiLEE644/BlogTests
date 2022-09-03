public class ThreadCreation3 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread("Thread1");
        t.start();
        t.join();
    }

    private static class MyThread extends Thread {
        MyThread(String threadName) {
            super(threadName);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
