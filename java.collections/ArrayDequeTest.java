import java.util.ArrayDeque;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.removeLast());
        }

        System.out.println();

        ArrayDeque<Integer> queue = stack;

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.removeFirst());
        }
    }
}