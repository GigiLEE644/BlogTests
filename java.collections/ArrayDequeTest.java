import java.util.ArrayDeque;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println();

        ArrayDeque<Integer> queue = stack;

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}