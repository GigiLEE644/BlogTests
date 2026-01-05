public class ThreadStateTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getState());
    }
}
/*
Output:
    RUNNABLE
 */