import java.util.concurrent.TimeUnit;

/**
 * -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999
 */
public class RandomTest {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            double random = Math.random();
            System.out.println(random);
        }
    }
}