import java.util.StringJoiner;

public class Java8NewFeaturesTest108 {

    public static void main(String[] args) {
        String prefix = "[";
        String suffix = "]";

        StringJoiner sj1 = new StringJoiner(",", prefix, suffix);

        sj1.add("a").add("b");

        System.out.println("sj1 = " + sj1.toString());

        StringJoiner sj2 = new StringJoiner(",", prefix, suffix);

        sj2.add("c").add("d");

        System.out.println("sj2 = " + sj2.toString());

        sj1.merge(sj2);

        System.out.println("sj1 after merging sj2 = " + sj1.toString());
        System.out.println("sj2 being mered by sj1 = " + sj2.toString());

        System.out.println();

        StringJoiner sj3 = new StringJoiner(",", prefix, suffix);

        sj3.add("a").add("b");

        System.out.println("sj3 = " + sj3.toString());

        StringJoiner sj4 = new StringJoiner("-", prefix, suffix);

        sj4.add("c").add("d");

        System.out.println("sj4 = " + sj4.toString());

        sj3.merge(sj4);

        System.out.println("sj3 after merging sj4 = " + sj3.toString());
        System.out.println("sj4 after being merged by sj3 = " + sj4.toString());
    }
}