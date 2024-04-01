import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Java8NewFeaturesTest74 {
    public static void main(String[] args) {
        int start = 0;
        int end = 10000;

        List<Integer> nums = new ArrayList<>();

        IntStream.range(start, end)
                .filter(i -> i % 2 == 0).forEach(i -> nums.add(i));

        System.out.println(nums.size());

        nums.clear();
        System.out.println();

        IntStream.range(start, end)
                .parallel()
                .filter(i -> i % 2 == 0).forEach(i -> nums.add(i));

        System.out.println(nums.size());
    }
}
