import java.util.stream.Stream;

public class Java8NewFeaturesTest30 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        sort(Stream.of(arr)).forEach(System.out::println);

        System.out.println();

        sort(Stream.of(arr).parallel().sequential()).forEach(System.out::println);

        System.out.println();

        sort(Stream.of(arr).parallel()).sequential().forEach(System.out::println);
    }

    private static Stream<Integer> sort(Stream<Integer> s) {
        return s.sorted()
                .peek(i -> {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                });
    }
}
/**
 * Output:
        main : 1
        1
        main : 2
        2
        main : 3
        3
        main : 4
        4
        
        main : 1
        1
        main : 2
        2
        main : 3
        3
        main : 4
        4
        
        main : 1
        1
        main : 2
        2
        main : 3
        3
        main : 4
        4
 */