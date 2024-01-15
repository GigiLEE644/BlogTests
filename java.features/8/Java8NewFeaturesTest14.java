import java.util.List;
import java.util.Arrays;

public class Java8NewFeaturesTest14 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        int total = numbers.stream().filter(current -> current < 10).mapToInt(current -> current).sum();
        System.out.println(total);
    }
}
