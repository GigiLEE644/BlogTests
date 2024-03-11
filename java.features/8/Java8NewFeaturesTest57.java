import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8NewFeaturesTest57 {
    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(System.out::println);

        System.out.println();

        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        System.out.println();

        System.out.println(IntStream.range(1, 5).sum());

        System.out.println();

        System.out.println(IntStream.range(1, 5).average().getAsDouble());

        System.out.println();

        Stream.of("1", "2", "3", "4").mapToInt(Integer::parseInt).forEach(System.out::println);

        System.out.println();

        IntStream.range(1, 5).boxed().forEach(System.out::println);

        System.out.println();

        IntStream.range(1, 5).mapToObj(i -> "" + i).forEach(System.out::println);
    }
}
