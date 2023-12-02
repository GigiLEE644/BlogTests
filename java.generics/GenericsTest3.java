import java.util.ArrayList;
import java.util.List;

public class GenericsTest3 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add("1");
        list.add(1l);
        list.add(1d);
        list.add(1f);

        list.stream().forEach(e -> {
            if (e instanceof Integer) {
                System.out.println("Integer : " + (Integer) e);
            }

            if (e instanceof String) {
                System.out.println("String : " + (String) e);
            }

            if (e instanceof Long) {
                System.out.println("Long : " + (Long) e);
            }

            if (e instanceof Double) {
                System.out.println("Double : " + (Double) e);
            }

            if (e instanceof Float) {
                System.out.println("Float : " + (Float) e);
            }
        });
    }
}
