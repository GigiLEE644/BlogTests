public class ByteCodeTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = add(a, b);

        System.out.println(a + " + " + b + " = " + c);

        // String name = ByteCodeTest.class.getName() + ".class";
        // URL url = ByteCodeTest.class.getResource(name);
        // System.out.println(url.getPath());
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
