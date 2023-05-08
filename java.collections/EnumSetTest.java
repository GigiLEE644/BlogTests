import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class EnumSetTest {
    enum Color {
        RED, YELLOW, GREEN, BLUE, BLACK, WHITE
    }

    public static void main(String[] args) {
        Set<Color> set = EnumSet.allOf(Color.class);

        System.out.println(set);
        System.out.println();

        Iterator<Color> it = set.iterator();

        while (it.hasNext()) {
            Color color = it.next();

            System.out.println(color);
        }
    }
}