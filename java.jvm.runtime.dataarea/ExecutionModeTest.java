import java.time.Duration;
import java.time.Instant;

public class ExecutionModeTest {
    /**
     * -Xint -Xcomp -Xmixed -XX:+PrintCompilation
     */
    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        heavyCalculation(1000000);
        Instant inst2 = Instant.now();
        System.out.println("Elapsed Time: " + Duration.between(inst1, inst2).toMillis() + " ms");
    }

    private static void heavyCalculation(int count) {
        for (int i = 0; i < count; i++) {
            prime(100);
        }
    }

    private static void prime(int n) {
        label: for (int j = 2; j <= n; j++) {
            for (int k = 2; k <= Math.sqrt(j); k++) {
                if (j % k == 0) {
                    continue label;
                }
            }
            // System.out.println(j);
        }
    }
}
