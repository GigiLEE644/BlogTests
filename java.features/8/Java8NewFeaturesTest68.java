import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest68 {
    public static void main(String[] args) {
        String[] names = { "tom", "jerry", "spike", "tyke" };

        List<String> nameList = Stream.of(names).collect(Collectors.toList());

        nameList.forEach(System.out::println);

        System.out.println();

        List<String> nameList2 = Arrays.asList(names);

        nameList2.forEach(System.out::println);
    }
}
