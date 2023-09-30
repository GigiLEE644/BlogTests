import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest6 {
    public static void main(String[] args) {
        readFile("this_is_a_test.txt");
    }

    private static void readFile(String fileName) {
        File file = new File(fileName);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            System.out.println("This line should not be printed, below lines should not be executed");

            byte[] bytes = fis.readAllBytes();

            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException!!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Caught IOException!!!");
            e.printStackTrace();
        } finally {
            System.out.println("Execute in finally.");
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("The end of program.");
    }
}
