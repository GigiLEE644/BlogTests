import java.util.List;
import java.util.function.Function;
import java.util.Arrays;

public class Java8NewFeaturesTest10 {
    public static void main(String[] args) {
        List<String> messages = Arrays.asList("hello", "world");

        // Function<List<String>, Displayer> f = l -> new Displayer(l);

        Function<List<String>, Displayer> f = Displayer::new;

        Displayer d = f.apply(messages);

        d.display();
    }

    private static class Displayer {
        private List<String> messages;

        Displayer(List<String> messages) {
            this.messages = messages;
        }

        void display() {
            for (int i = 0; i < this.messages.size(); i++) {
                System.out.println(this.messages.get(i));
            }
        }
    }
}
/**
 * Output:
 *      hello
 *      world
 */
