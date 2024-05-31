import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Java8NewFeaturesTest106 {

    public static void main(String[] args) {
        String delimiter = ",";
        String prefix = "[";
        String suffix = "]";

        StringJoiner sj1 = new StringJoiner(delimiter, prefix, suffix);

        sj1.add("hello").add("world");

        System.out.println(sj1.toString());

        StringJoiner sj2 = new StringJoiner(delimiter, prefix, suffix);

        List<String> greetings = new ArrayList<>();

        greetings.add("hello");
        greetings.add("world");

        for (String greeting : greetings) {
            sj2.add(greeting);
        }

        System.out.println(sj2.toString());
    }
}