import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8NewFeaturesTest75 {
    public static void main(String[] args) {
        int start = 0;
        int end = 10000;

        List<Integer> nums = IntStream.range(start, end)
                .parallel()
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(nums.size());
    }
}
