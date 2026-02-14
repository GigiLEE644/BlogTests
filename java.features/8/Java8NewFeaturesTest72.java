import java.util.ArrayList;
import java.util.List;

public class Java8NewFeaturesTest72 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);

        long count = nums.stream().count();

        System.out.println(count);

        System.out.println();

        System.out.println(nums.size());
    }
}
/**
 * Output:
 * 3
 * 
 * 3
 */