import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java8NewFeaturesTest3 {
    public static void main(String[] args) {
        Consumer<List<Integer>> modify = l -> {
            for (int i = 0; i < l.size(); i++) {
                l.set(i, 2 * l.get(i));
            }
        };

        Consumer<List<Integer>> display = l -> {
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println();
        };

        List<Integer> l = new ArrayList<Integer>();
        
        l.add(1);
        l.add(2);
        l.add(3);

        display.andThen(modify).andThen(display).accept(l);
    }
}
/**
 * Output:
 *          1 2 3 
 *          2 4 6
 */