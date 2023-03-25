import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Integer> stack = new LinkedBlockingDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        System.out.println(stack.takeFirst());
        System.out.println(stack.takeFirst());
        System.out.println(stack.takeFirst());
        System.out.println(stack.takeFirst());

        System.out
                .println("Thie line will never be printed bcz the main thread is blocked for taking from empty stack");
    }
}
