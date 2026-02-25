import java.util.Optional;

public class Java8NewFeaturesTest88 {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("tom");

        System.out.println(name.get());

        System.out.println();

        name = Optional.ofNullable(null);

        System.out.println(name.get());
    }
}
/**
 * Output:
    tom
    
    java.util.NoSuchElementException: No value present
            at java.base/java.util.Optional.get(Optional.java:143)
            at Java8NewFeaturesTest88.main(Java8NewFeaturesTest88.java:12)
 */