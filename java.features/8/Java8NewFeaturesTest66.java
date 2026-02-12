import java.util.stream.IntStream;

public class Java8NewFeaturesTest66 {
    public static void main(String[] args) {
        int n = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + "," + j);
            }
        }

        System.out.println();

        IntStream.range(0, n).forEach(i -> {
            IntStream.range(0, n).forEach(j -> {
                System.out.println(i + "," + j);
            });
        });
    }
}
/**
 * Output:
 
    0,0
    0,1
    1,0
    1,1
    
    0,0
    0,1
    1,0
    1,1
 */