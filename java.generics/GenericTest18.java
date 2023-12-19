import java.util.ArrayList;
import java.util.List;

public class GenericTest18 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();

        List<String> l2 = new ArrayList<>();

        System.out.println(l1.getClass() == l2.getClass());
    }
}
