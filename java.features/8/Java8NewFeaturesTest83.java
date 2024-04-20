import java.util.Optional;

public class Java8NewFeaturesTest83 {
    public static void main(String[] args) {
        Optional<String> opt1 = Optional.of("tom");

        System.out.println(opt1.isPresent());
        System.out.println(!opt1.isEmpty());
        System.out.println();

        Optional<String> opt2 = Optional.ofNullable(null);

        System.out.println(opt2.isPresent());
        System.out.println(!opt2.isEmpty());
        System.out.println();

        Optional<Object> opt3 = Optional.empty();

        System.out.println(opt3.isPresent());
        System.out.println(!opt3.isEmpty());
        System.out.println();
    }
}
