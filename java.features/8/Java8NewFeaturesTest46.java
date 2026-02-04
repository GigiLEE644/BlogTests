import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest46 {
    public static void main(String[] args) {
        String[] words = { "hello", "world" };

        Long count = Stream.of(words).collect(Collectors.counting());

        System.out.println(count);
    }
}
/**
 * Output:
        2
 */