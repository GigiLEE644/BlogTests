public class StrongReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        // uncomment below will make obj unreachable and recyclable by gc
        // obj = null;

        System.gc();

        Thread.currentThread().sleep(3000);

        if (obj == null) {
            System.out.println("obj does not exist anymore after gc");
        } else {
            System.out.println("obj is alive after gc");
        }
    }
}