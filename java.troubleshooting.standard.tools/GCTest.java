import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 */
public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(new byte[1024 * 100]); // 100KB

            TimeUnit.MILLISECONDS.sleep(120);
        }
    }
}
