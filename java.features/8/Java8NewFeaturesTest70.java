import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8NewFeaturesTest70 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("tom");
        names.add("tom");
        names.add("jerry");
        names.add("jerry");
        names.add("spike");
        names.add("spike");
        names.add("tyke");
        names.add("tyke");

        Set<String> nameSet = names.stream().collect(Collectors.toSet());

        nameSet.forEach(System.out::println);

        System.out.println();

        Set<String> nameSet2 = new HashSet<>(names);

        nameSet2.forEach(System.out::println);
    }
}
