import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(5);
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(3);

        set.spliterator().forEachRemaining(System.out::println);

        System.out.println();

        set = new LinkedHashSet<>();

        set.add(5);
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(3);

        set.spliterator().forEachRemaining(System.out::println);
    }
}