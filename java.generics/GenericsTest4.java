import java.util.ArrayList;
import java.util.List;

public class GenericsTest4 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();

        intList.add(1);

        intList.forEach(System.out::println);

        List<String> stringList = new ArrayList<>();

        stringList.add("1");

        stringList.forEach(System.out::println);

        List<Long> longList = new ArrayList<>();

        longList.add(1l);

        longList.forEach(System.out::println);

        List<Float> floatList = new ArrayList<>();

        floatList.add(1f);

        floatList.forEach(System.out::println);

        List<Double> doubleList = new ArrayList<>();

        doubleList.add(1d);

        doubleList.forEach(System.out::println);
    }
}
