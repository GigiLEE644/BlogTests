import java.util.Arrays;
import java.util.List;

public class Java8NewFeaturesTest65 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        nums.forEach(System.out::println);
    }
}
/**
 * Output:
 * 1
 * 2
 * 3
 * 4
 * 5
 */