import java.util.stream.Stream;

public class Java8NewFeaturesTest34 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        Stream.of(arr).parallel().forEach(System.out::println);

        System.out.println();

        Stream.of(arr).parallel().forEachOrdered(System.out::println);
    }
}
/**
 * Output:
        4
        2
        3
        1
        
        1
        3
        4
        2
 */