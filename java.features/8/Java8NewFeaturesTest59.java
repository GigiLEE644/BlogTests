import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8NewFeaturesTest59 {
    public static void main(String[] args) {
        IntStream.range(1, 5).boxed().forEach(System.out::println);

        System.out.println();

        IntStream.range(1, 5).mapToObj(i -> "" + i).forEach(System.out::println);

        System.out.println();

        Stream.of("1", "2", "3", "4").mapToInt(Integer::parseInt).forEach(System.out::println);
    }
}
