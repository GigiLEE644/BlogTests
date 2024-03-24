import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8NewFeaturesTest69 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("tom");
        names.add("jerry");
        names.add("spike");
        names.add("tyke");

        String[] nameArray = names.stream().toArray(String[]::new);

        for (String name : nameArray) {
            System.out.println(name);
        }

        System.out.println();

        String[] nameArray2 = names.toArray(new String[0]);

        for (String name : nameArray2) {
            System.out.println(name);
        }
    }
}
