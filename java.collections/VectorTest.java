import java.util.Iterator;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        v.add(1);
        v.add(2);
        v.addElement(3);
        v.addElement(4);

        System.out.println("Size of vector = " + v.size());

        Iterator<Integer> it = v.iterator();

        while (it.hasNext()) {
            Integer element = it.next();
            System.out.println(element);
        }

        v.remove(0);

        System.out.println(v);

        v.remove(Integer.valueOf(4));

        System.out.println(v);

        v.removeAllElements();

        System.out.println("Size of vector = " + v.size());
    }
}
