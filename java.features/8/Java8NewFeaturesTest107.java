import java.util.StringJoiner;

public class Java8NewFeaturesTest107 {

    public static void main(String[] args) {
        String delimiter = ",";
        String prefix = "[";
        String suffix = "]";

        StringJoiner sj1 = new StringJoiner(delimiter, prefix, suffix);

        System.out.println(sj1.toString());

        StringJoiner sj2 = new StringJoiner(delimiter);

        System.out.println(sj2.toString());

        StringJoiner sj3 = new StringJoiner(delimiter, prefix, suffix);

        sj3.setEmptyValue("defaultValue");

        System.out.println(sj3.toString());

        StringJoiner sj4 = new StringJoiner(delimiter);

        sj4.setEmptyValue("defaultValue");

        System.out.println(sj4.toString());

        StringJoiner sj5 = new StringJoiner(delimiter, prefix, suffix);

        sj5.setEmptyValue("defaultValue");
        sj5.add("hello");

        System.out.println(sj5.toString());

        StringJoiner sj6 = new StringJoiner(delimiter);

        sj6.setEmptyValue("defaultValue");
        sj6.add("world");

        System.out.println(sj6.toString());
    }
}