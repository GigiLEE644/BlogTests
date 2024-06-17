import java.util.ArrayList;
import java.util.List;

public class Java11NewFeaturesTest5 {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);

        nums.stream().map(num -> num * 2).forEach(System.out::println);

        System.out.println();

        nums.stream().map((Integer num) -> num * 2).forEach(System.out::println);

        System.out.println();

        nums.stream().map((var num) -> num * 2).forEach(System.out::println);
    }
}