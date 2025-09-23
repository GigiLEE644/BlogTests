public class RuntimeMemoryTest {
    static class SmallObject {
        int x;
        int y;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // Warm up and GC
        System.gc();
        long before = runtime.totalMemory() - runtime.freeMemory();

        int count = 10_000_000;
        SmallObject[] objects = new SmallObject[count];
        for (int i = 0; i < count; i++) {
            objects[i] = new SmallObject();
        }

        long after = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Approximate memory used: " + (after - before) / (1024 * 1024) + " MB");
    }
}
/* Output:
        run with Java 21 => Approximate memory used: 285 MB
        run with Java 25 => Approximate memory used: 280 MB
*/