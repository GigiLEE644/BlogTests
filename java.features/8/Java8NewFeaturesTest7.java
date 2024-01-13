import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8NewFeaturesTest7 {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "world");

        /*
        Consumer<List<String>> c = l -> {
            Displayer.display(l);
        };
        */

        Consumer<List<String>> c = Displayer::display;

        c.accept(messages);
    }

    private static class Displayer {
        private static void display(List<String> l) {
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i));
            }
        }
    }
}
