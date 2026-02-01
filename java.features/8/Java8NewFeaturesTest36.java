import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Java8NewFeaturesTest36 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        Comparator<Integer> cmp = Comparator.comparingInt(i -> i);

        Optional<Integer> min = Stream.of(arr).min(cmp);

        System.out.println(min.get());

        Optional<Integer> max = Stream.of(arr).max(cmp);

        System.out.println(max.get());
    }
}
/** 
 * Output:
 * 1
 * 4
 */