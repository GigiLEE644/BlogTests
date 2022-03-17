import java.util.ArrayList;
import java.util.List;

public class GCRootsTest {
    public static void main(String[] args) throws InterruptedException {
        List<MyClass> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(new MyClass());
        }

        Thread.currentThread().join();
    }

    private static class MyClass {

    }
}
