import java.util.stream.Stream;

public class Java8NewFeaturesTest31 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        Stream<Integer> s = Stream.of(arr);

        s.forEach(System.out::println);
    }
}
