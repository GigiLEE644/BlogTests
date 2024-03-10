import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Java8NewFeaturesTest58 {
    public static void main(String[] args) {
        Instant t1 = Instant.now();
        System.out.println(sum());
        Instant t2 = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(t1, t2).toMillis() + " ms.");

        System.out.println();

        t1 = Instant.now();
        System.out.println(sum2());
        t2 = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(t1, t2).toMillis() + " ms.");
    }

    public static Long sum() {
        return Stream
                .iterate(0L, i -> i + 1L)
                .limit(100_000_000)
                .filter(i -> (i % 2) == 0)
                .map(i -> i + 1)
                .sorted()
                .reduce(0L, Long::sum);
    }

    public static long sum2() {
        return LongStream
                .iterate(0L, i -> i + 1L)
                .limit(100_000_000)
                .filter(i -> (i % 2) == 0)
                .map(i -> i + 1)
                .sorted()
                .reduce(0L, Long::sum);
    }
}
