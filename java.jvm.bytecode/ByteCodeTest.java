public class ByteCodeTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = add(a, b);

        System.out.println(c);
    }

    private static int add(int a, int b) {
        return a + b;
    }
}