import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Java8NewFeaturesTest9 {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "world");

        Displayer d = new Displayer();

        /*
         * BiConsumer<Displayer, List<String>> c = (d, l) -> {
         *      d.display(l);
         * };
         */

        BiConsumer<Displayer, List<String>> c = Displayer::display;

        c.accept(d, messages);
    }

    private static class Displayer {
        void display(List<String> l) {
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i));
            }
        }
    }
}
