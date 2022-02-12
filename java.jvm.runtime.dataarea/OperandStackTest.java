import java.util.Arrays;

public class OperandStackTest {
    public static void main(String[] args) {
        class Addition {
            int add(int a, int b) {
                return a + b;
            }

            int inc(int a) {
                return add(a, 1);
            }
        }

        int num = 99;

        System.out.println(num + " increse by 1 = " + new Addition().inc(num));
    }
}
