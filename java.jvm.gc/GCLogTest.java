import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+UseParallelGC
 * -verbose:gc
 * -XX:+PrintGC or -Xlog:gc
 * -XX:+PrintGCDetails or -Xlog:gc*
 * -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
 */
public class GCLogTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            list.add(new byte[1024 * 100]); // 100KB
        }
    }
}