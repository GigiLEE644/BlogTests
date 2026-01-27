import java.util.stream.Stream;

public class Java8NewFeaturesTest28 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        Stream<Integer> s = Stream.of(arr);

        s.forEach(System.out::println);

        System.out.println();

        s.forEach(System.out::println);
    }
}
/**
 * Output:
 *      1
 *      3
 *      4
 *      2
 * 
 *      Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
 *          at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
 *          at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:647)
 *          at Java8NewFeaturesTest28.main(Java8NewFeaturesTest28.java:10)
 */