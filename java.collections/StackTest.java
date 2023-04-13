import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());

        System.out.println(stack.search(3));

        System.out.println();

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        System.out.println();

        System.out.println(stack.search(3));
    }
}
