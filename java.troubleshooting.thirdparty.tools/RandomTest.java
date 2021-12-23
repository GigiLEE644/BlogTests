import java.util.concurrent.TimeUnit;

/**
 * -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999
 */
public class RandomTest {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            sleep(1);
            print(random());
        }
    }

    private static void print(double random) {
        System.out.println(random);
    }

    private static double random() {
        return Math.random();
    }

    private static void sleep(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
    }
}