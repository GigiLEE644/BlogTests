import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionTest1 {
    public static void main(String[] args) throws IOException {
        readFile("this_is_a_test.txt");
    }

    private static void readFile(String fileName) throws IOException {
        File file = new File(fileName);

        FileInputStream fis = new FileInputStream(file);

        byte[] bytes = fis.readAllBytes();

        System.out.println(new String(bytes));
    }
}
