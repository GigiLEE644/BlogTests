import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc
 */
public class GCLogTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            list.add(new byte[1024 * 100]); //100KB
        }
    }
}
