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
/**
 * Output:
    java.util.NoSuchElementException: No value present
        at java.base/java.util.Optional.orElseThrow(Optional.java:377)
        at Java8NewFeaturesTest87.main(Java8NewFeaturesTest87.java:6)

    Exception in thread "main" java.lang.RuntimeException: no such element
        at Java8NewFeaturesTest87.lambda$0(Java8NewFeaturesTest87.java:13)
        at java.base/java.util.Optional.orElseThrow(Optional.java:403)
        at Java8NewFeaturesTest87.main(Java8NewFeaturesTest87.java:13)
 */