import java.util.Iterator;
import java.util.stream.Stream;

public class Java8NewFeaturesTest40 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 4, 2 };

        Iterator<Integer> it = Stream.of(nums).iterator();

        while (it.hasNext()) {
            Integer num = it.next();
            System.out.println(num);
        }

        System.out.println();

        for (int num : (Iterable<Integer>) Stream.of(nums)::iterator) {
            System.out.println(num);
        }
    }
}
