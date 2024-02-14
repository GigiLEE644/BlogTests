import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest47 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4 };

        IntSummaryStatistics iss = Stream.of(nums).collect(Collectors.summarizingInt(num -> num));

        System.out.println("average : " + iss.getAverage());
        System.out.println("count : " + iss.getCount());
        System.out.println("max : " + iss.getMax());
        System.out.println("min : " + iss.getMin());
        System.out.println("sum : " + iss.getSum());
    }
}
