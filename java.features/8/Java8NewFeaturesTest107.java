import java.util.StringJoiner;

public class Java8NewFeaturesTest107 {

    public static void main(String[] args) {
        String delimiter = ",";
        String prefix = "[";
        String suffix = "]";

        StringJoiner sj1 = new StringJoiner(delimiter);

        System.out.println(sj1.toString());

        StringJoiner sj2 = new StringJoiner(delimiter, prefix, suffix);

        System.out.println(sj2.toString());

        StringJoiner sj3 = new StringJoiner(delimiter);

        sj3.setEmptyValue("defaultValue");

        System.out.println(sj3.toString());
    }
}