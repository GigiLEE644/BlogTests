import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest16 {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("hello", "world");

        Stream<String> s;

        if (l == null || l.isEmpty()) {
            s = Stream.empty();
        } else {
            s = l.stream();
        }

        s.forEach(System.out::println);
    }
}
