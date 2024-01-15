import java.util.List;
import java.util.Arrays;

public class Java8NewFeaturesTest11 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        int total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current < 10) {
                total += current;
            }
        }
        System.out.println(total);
    }
}
