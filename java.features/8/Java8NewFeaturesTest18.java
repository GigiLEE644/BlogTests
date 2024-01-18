import java.util.stream.Stream;

public class Java8NewFeaturesTest18 {
    public static void main(String[] args) {
        String hello = "hello";
        String world = "world";

        // Builder
        Stream<String> s1 = Stream.<String>builder().add(hello).add(world).build();

        s1.forEach(System.out::println);

        System.out.println();

        // Generate
        Stream<String> s2 = Stream.generate(() -> hello).limit(1);

        s2.forEach(System.out::println);

        System.out.println();

        // Iterate
        Stream<String> s3 = Stream.iterate(world, str -> str).limit(1);

        s3.forEach(System.out::println);

        System.out.println();

        // Of
        Stream<String> s4 = Stream.of(new String[] { hello, world });
        s4.forEach(System.out::println);
    }
}
