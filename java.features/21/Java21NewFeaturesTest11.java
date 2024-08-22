import java.time.Duration;
import java.time.Instant;

public class Java21NewFeaturesTest11 {

        public static void main(String[] args) {
                int n = 1000;

                Instant start = Instant.now();

                runThread(n);

                System.out.println("Run " + n + " threads, elapsed time = "
                                + Duration.between(start, Instant.now()).toMillis());

                start = Instant.now();

                runVirtualThread(n);

                System.out.println("Run " + n + " virtual threads, elapsed time = "
                                + Duration.between(start, Instant.now()).toMillis());
        }

        private static void runVirtualThread(int n) {
                for (int i = 0; i < n; i++) {
                        Thread t = Thread.startVirtualThread(() -> {

                        });

                        try {
                                t.join();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }

        private static void runThread(int n) {
                for (int i = 0; i < n; i++) {
                        Thread t = new Thread(() -> {

                        });

                        try {
                                t.start();
                                t.join();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
}