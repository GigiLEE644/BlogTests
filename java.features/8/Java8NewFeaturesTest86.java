import java.util.Optional;

public class Java8NewFeaturesTest86 {
    public static void main(String[] args) {
        String jerry = "jerry";

        Object name = Optional.ofNullable(jerry).orElse(getDefaultValue("Inside orElse"));

        System.out.println(name);

        System.out.println();

        name = Optional.ofNullable(jerry).orElseGet(() -> getDefaultValue("Inside orElseGet"));

        System.out.println(name);
    }

    private static String getDefaultValue(String message) {
        System.out.println(message);
        return "tom";
    }
}
