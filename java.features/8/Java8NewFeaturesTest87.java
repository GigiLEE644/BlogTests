import java.util.Optional;

public class Java8NewFeaturesTest87 {
    public static void main(String[] args) {
        try {
            Optional.ofNullable(null).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        Optional.ofNullable(null).orElseThrow(() -> new RuntimeException("no such element"));
    }
}
