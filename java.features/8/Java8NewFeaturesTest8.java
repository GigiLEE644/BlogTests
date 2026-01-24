import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8NewFeaturesTest8 {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "world");

        Displayer d = new Displayer();

        /*
         * Consumer<List<String>> c = l -> {
         *      d.display(l);
         * };
         */

        Consumer<List<String>> c = d::display;

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
/**
 * Output:
 *      hello
 *      world
 */
