import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println("Queue contents: " + queue);

        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.println(element);
        }

        System.out.println();

        queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println("Queue contents: " + queue);

        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.println(element);
        }
    }
}
