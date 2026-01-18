import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * -Xms10m -Xmx10m
 */
public class MemoryLeakTest6 {
    public static void main(String[] args) throws FileNotFoundException {
        String dir = new File("").getAbsolutePath();
        String name = dir + File.separator + "README.md";

        // keep opening stream without closing
        while (true) {
            FileInputStream fis = new FileInputStream(name);
        }
    }
}
/**
 * Output:
 *      Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *          at java.base/java.io.FileInputStream.<init>(FileInputStream.java:219)
 *          at MemoryLeakTest6.main(MemoryLeakTest6.java:15)
 */