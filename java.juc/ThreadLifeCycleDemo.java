public class ThreadLifeCycleDemo extends Thread {
    public void run() {
        System.out.println("Thread is running...");
        try {
            Thread.sleep(1000); // TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycleDemo t = new ThreadLifeCycleDemo();

        System.out.println("State after creating: " + t.getState()); // NEW
        t.start();
        System.out.println("State after start(): " + t.getState()); // RUNNABLE

        Thread.sleep(100); // Small delay to let thread enter sleep
        System.out.println("State during sleep(): " + t.getState()); // TIMED_WAITING

        t.join();
        System.out.println("State after thread finished: " + t.getState()); // TERMINATED
    }
}