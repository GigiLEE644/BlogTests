import java.util.ArrayList;
import java.util.List;

public class Java11NewFeaturesTest3 {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("hello");
        l.add("world");

        String[] a = l.toArray(new String[l.size()]);

        display(a);

        String[] a2 = l.toArray(size -> {
            return new String[size];
        });

        display(a2);

        String[] a3 = l.toArray(String[]::new);

        display(a3);
    }

    private static void display(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }
}