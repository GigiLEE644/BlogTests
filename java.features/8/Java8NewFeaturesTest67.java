import java.util.stream.IntStream;

public class Java8NewFeaturesTest67 {
    public static void main(String[] args) {
        int n = 2;

        try {
            for (int i = 0; i < n; i++) {
                System.out.println(i / 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println();

            IntStream.range(0, n).forEach(i -> {
                System.out.println(i / 0);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
