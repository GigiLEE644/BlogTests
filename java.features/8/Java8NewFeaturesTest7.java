import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8NewFeaturesTest7 {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "world");

        handle(messages, Java8NewFeaturesTest7::display);
    }

    private static void handle(List<String> messages, Consumer<List<String>> c) {
        c.accept(messages);
    }

    private static void display(List<String> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
