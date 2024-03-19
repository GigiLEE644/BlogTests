import java.util.function.Supplier;
import java.util.stream.Stream;

public class Java8NewFeaturesTest63 {
    public static void main(String[] args) {
        Supplier<Stream<Integer>> s = () -> Stream.of(1, 2, 3, 4, 5);

        s.get().forEach(System.out::println);
        s.get().forEach(System.out::println);
    }
}
