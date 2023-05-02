import java.util.Collections;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(2);
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(4);

        set.spliterator().forEachRemaining(System.out::println);

        System.out.println();

        set = new TreeSet<>(Collections.reverseOrder());

        set.add(2);
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(4);

        set.spliterator().forEachRemaining(System.out::println);
    }
}