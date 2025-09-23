public class ScalarLoopExample {
    public static void main(String[] args) {
        float[] a = { 1f, 2f, 3f, 4f };
        float[] b = { 5f, 6f, 7f, 8f };
        
        float[] c = new float[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i]; // one addition per loop iteration
        }

        System.out.println(java.util.Arrays.toString(c));
    }
}
/* Output:
        [6.0, 8.0, 10.0, 12.0]
*/