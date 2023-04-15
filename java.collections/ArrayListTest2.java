import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListTest2 {
    public static void main(String[] args) {
        String[] array = { "a", "b", "c", "d", "e" };

        // Method 1
        List<String> list1 = Arrays.asList(array);
        System.out.println(list1);

        // Method 2
        List<String> list2 = new ArrayList<String>();
        Collections.addAll(list2, array);
        System.out.println(list2);

        // Method 3
        List<String> list3 = new ArrayList<String>();
        for (String text : array) {
            list3.add(text);
        }
        System.out.println(list3);
    }
}
