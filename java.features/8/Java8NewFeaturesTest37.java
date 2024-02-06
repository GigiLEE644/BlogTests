import java.util.Optional;
import java.util.stream.Stream;

public class Java8NewFeaturesTest37 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        Optional<Integer> first = Stream.of(arr).findFirst();

        System.out.println(first.get());

        Optional<Integer> any = Stream.of(arr).findAny();

        System.out.println(any.get());
    }
}
