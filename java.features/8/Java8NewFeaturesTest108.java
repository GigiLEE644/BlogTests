import java.util.StringJoiner;

public class Java8NewFeaturesTest108 {

    public static void main(String[] args) {
        String delimiter = ",";
        String prefix = "[";
        String suffix = "]";

        StringJoiner sj1 = new StringJoiner(delimiter, prefix, suffix);

        sj1.add("a").add("b");

        System.out.println(sj1.toString());

        StringJoiner sj2 = new StringJoiner(delimiter, prefix, suffix);

        sj2.add("c").add("d");

        sj1.merge(sj2);

        System.out.println(sj2.toString());
        System.out.println(sj1.toString());
    }
}