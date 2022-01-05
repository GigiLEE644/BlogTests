import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m
 */
public class MemoryLeakTest {
    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            byte[] tenMB = new byte[1024 * 1024 * 10];

            list.add(tenMB);
        }

        System.out.println("Static list is filled, so far no OOM");

        // below creation of 20Mb object will cause OOM
        // since list holds useless objects which cause memory leak
        byte[] twentyMB = new byte[1024 * 1024 * 20];
        System.out.println(twentyMB);
    }
}
