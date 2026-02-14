import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java8NewFeaturesTest71 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        int maximum = nums.stream().max((i1, i2) -> i1.compareTo(i2)).orElse(nums.get(0));

        System.out.println(maximum);

        System.out.println();

        maximum = Collections.max(nums);

        System.out.println(maximum);
    }
}
/**
 * Output:
 * 4
 * 
 * 4
 */