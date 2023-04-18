import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.addLast("C");
        list.addFirst("D");
        list.add(2, "E");

        System.out.println(list);

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String element = it.next();
            System.out.println(element);
        }

        list.remove("B");
        String removed = list.remove(3);
        System.out.println(removed + " has been removed from linked list");
        removed = list.removeFirst();
        System.out.println(removed + " has been removed from linked list");
        removed = list.removeLast();
        System.out.println(removed + " has been removed from linked list");

        System.out.println(list);
    }
}