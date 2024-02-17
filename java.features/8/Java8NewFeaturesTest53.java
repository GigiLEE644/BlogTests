import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest53 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        int sum = Stream.of(nums)
                .collect(Collectors.reducing(0, (reduced, current) -> reduced + current));

        System.out.println(sum);

        int mappedSum = Stream.of(nums)
                .collect(Collectors.reducing(0, i -> 2 * i, (reduced, current) -> reduced + current));

        System.out.println(mappedSum);
    }
}
