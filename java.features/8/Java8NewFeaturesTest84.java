import java.util.Optional;

public class Java8NewFeaturesTest84 {
    public static void main(String[] args) {
        String name = "tom";

        if (name != null) {
            System.out.println(name);
        }

        System.out.println();

        Optional<String> opt = Optional.of(name);

        opt.ifPresent(System.out::println);
    }
}
