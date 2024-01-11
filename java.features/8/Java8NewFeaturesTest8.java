import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8NewFeaturesTest8 {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "world");

        Displayer displayer = new Displayer();

        handle(messages, displayer::display);
    }

    private static void handle(List<String> messages, Consumer<List<String>> c) {
        c.accept(messages);
    }

    private static class Displayer {
        void display(List<String> l) {
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i));
            }
        }
    }
}
