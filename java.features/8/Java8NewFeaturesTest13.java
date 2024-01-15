import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Java8NewFeaturesTest13 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        int total = 0;
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            int current = it.next();
            if (current < 10) {
                total += current;
            }
        }
        System.out.println(total);
    }
}
