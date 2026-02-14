import java.util.ArrayList;
import java.util.List;

public class Java8NewFeaturesTest73 {
    public static void main(String[] args) {
        int find = 2;

        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(find);
        nums.add(3);

        boolean exist = nums.stream().anyMatch(i -> i == find);

        System.out.println(exist);

        System.out.println();

        System.out.println(nums.contains(find));
    }
}
/**
 * Output:
 * true
 * 
 * true
 */