import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest52 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        Stream<Integer> s = Stream.of(nums);

        List<Integer> l = s
                .collect(Collectors.mapping(i -> i * 2, Collectors.toList()));

        for (int i : l) {
            System.out.println(i);
        }
    }
}
