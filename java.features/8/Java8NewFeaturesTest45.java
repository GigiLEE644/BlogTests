import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest45 {
    public static void main(String[] args) {
        String word = Stream.of("he", "ll", "o").collect(Collectors.joining());

        System.out.println(word);

        String[] words = { "hello", "world" };

        String phrase = Stream.of(words).collect(Collectors.joining(" "));

        System.out.println(phrase);

        String greeting = Stream.of(words).collect(Collectors.joining(" ", "tom : ", "!"));

        System.out.println(greeting);
    }
}
/**
 * Output:
        hello
        hello world
        tom : hello world!
 */