import java.util.stream.Stream;

public class Java8NewFeaturesTest38 {
    public static void main(String[] args) {
        Integer[] arr = { 1, 3, 4, 2 };

        System.out.println(Stream.of(arr).anyMatch(i -> i % 2 == 0));
        System.out.println(Stream.of(arr).allMatch(i -> i > 0));
        System.out.println(Stream.of(arr).noneMatch(i -> i < 0));
    }
}
