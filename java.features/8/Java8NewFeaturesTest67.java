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
/**
 Output:
    java.lang.ArithmeticException: / by zero
        at Java8NewFeaturesTest67.main(Java8NewFeaturesTest67.java:9)

    java.lang.ArithmeticException: / by zero
        at Java8NewFeaturesTest67.lambda$0(Java8NewFeaturesTest67.java:18)
        at java.base/java.util.stream.Streams$RangeIntSpliterator.forEachRemaining(Streams.java:104)
        at java.base/java.util.stream.IntPipeline$Head.forEach(IntPipeline.java:619)
        at Java8NewFeaturesTest67.main(Java8NewFeaturesTest67.java:17)
 */