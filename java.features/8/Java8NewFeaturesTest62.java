import java.util.stream.Stream;

public class Java8NewFeaturesTest62 {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);

        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }
}
