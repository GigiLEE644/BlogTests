import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer element = it.next();

            if (element == 1) {
                it.remove();
            } else {
                System.out.println(element);
            }
        }

        System.out.println(list);
    }
}
