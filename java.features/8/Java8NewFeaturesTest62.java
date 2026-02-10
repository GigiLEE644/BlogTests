import java.util.stream.Stream;

public class Java8NewFeaturesTest62 {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);

        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }
}
/**
 * Output:
        1
        2
        3
        4
        5
        Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
                at java.base/java.util.stream.AbstractPipeline.sourceStageSpliterator(AbstractPipeline.java:311)
                at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:803)
                at Java8NewFeaturesTest62.main(Java8NewFeaturesTest62.java:8)
 */