import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsTest16 {
    public static void main(String[] args) {
        List elements = new ArrayList();

        elements.add("1");

        Iterator it = elements.iterator();

        while (it.hasNext()) {
            Object element = it.next();

            System.out.println(element);
        }

        elements.add(2);

        for (int i = 0; i < elements.size(); i++) {
            Integer element = (Integer) elements.get(i);

            System.out.println(element);
        }
    }
}
