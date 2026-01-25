import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

public class Java8NewFeaturesTest15 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        AtomicInteger total = new AtomicInteger(0);
        numbers.forEach(n -> {
            if (n < 10) {
                total.getAndAdd(n);
            }
        });
        System.out.println(total.get());
    }
}
/**
 * Output:
 * 45
 */