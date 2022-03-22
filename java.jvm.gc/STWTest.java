import java.util.ArrayList;
import java.util.List;

public class STWTest {
    public static void main(String[] args) {
        TimerThread timer = new TimerThread();
        timer.start();

        // normally if uncomment below gc() method
        // the output should be like :
        // 1.0 secs
        // 1.1 secs
        // 1.1 secs
        // 1.0 secs
        // 1.1 secs
        // 1.1 secs
        // 1.1 secs
        gc();
    }

    private static void gc() {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                list.add(new byte[1024]);
            }

            list.clear();
            System.gc();
        }
    }

    private static class TimerThread extends Thread {
        @Override
        public void run() {
            long previous = System.currentTimeMillis();

            while (true) {
                sleep(1000);

                long current = System.currentTimeMillis();
                long duration = current - previous;
                previous = current;

                System.out.println(duration / 1000 + "." 
                + duration % 1000 + " secs");
            }
        }

        private void sleep(int millis) {
            try {
                Thread.currentThread().sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
