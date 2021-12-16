import java.util.Scanner;

public class ScanTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            scanner.next();
        }
    }
}