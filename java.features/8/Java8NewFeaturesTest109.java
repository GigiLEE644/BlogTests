import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8NewFeaturesTest109 {

    public static void main(String[] args) {
        List<String> greetings = new ArrayList<>();

        greetings.add("hello");
        greetings.add("world");

        String greeting = greetings.stream().collect(Collectors.joining(",", "[", "]"));

        System.out.println(greeting);
    }
}