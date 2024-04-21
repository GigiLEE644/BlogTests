import java.util.Optional;

public class Java8NewFeaturesTest85 {
    public static void main(String[] args) {
        Object name = Optional.ofNullable(null).orElse("tom");

        System.out.println(name);

        System.out.println();

        name = Optional.ofNullable(null).orElseGet(() -> "tom");

        System.out.println(name);
    }
}
