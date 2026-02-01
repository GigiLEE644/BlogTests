import java.util.Optional;
import java.util.stream.Stream;

public class Java8NewFeaturesTest33 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        Stream<Integer> s = Stream.of(arr);

        Optional<Integer> reduced = s.reduce((accumulated, current) -> accumulated += current);

        System.out.println(reduced.get());
    }
}
/**
 * Output:
 * 10
 */