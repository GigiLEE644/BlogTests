import java.util.concurrent.atomic.AtomicInteger;

public class CasWithAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger val = new AtomicInteger(0);

        System.out.println();

        System.out.println("Previous value: " + val.get());

        boolean res = val.compareAndSet(0, 6);

        checkResult(val, res);

        System.out.println("Previous value: " + val.get());

        res = val.compareAndSet(0, 0);

        checkResult(val, res);
    }

    private static void checkResult(AtomicInteger val, boolean res) {
        if (res) {
            System.out.println("The value was updated and it is " + val.get());
        } else {
            System.out.println("The value was not updated");
        }
        System.out.println();
    }
}
