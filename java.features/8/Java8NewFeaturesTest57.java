import java.util.stream.IntStream;

public class Java8NewFeaturesTest57 {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 5).sum());

        System.out.println();

        System.out.println(IntStream.range(1, 5).average().getAsDouble());
    }
}