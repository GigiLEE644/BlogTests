import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<ArrayList<Integer>> set = new HashSet<>();

        ArrayList<Integer> list1 = new ArrayList<>();

        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        set.add(list1);
        set.add(list2);

        System.out.println(list1.hashCode() == list2.hashCode());
        System.out.println(list1.equals(list2));

        System.out.println(set.size());
    }
}