import java.util.stream.Stream;

public class Java8NewFeaturesTest35 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        System.out.println(Stream.of(arr).count());
    }
}
