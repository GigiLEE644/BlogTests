import java.util.Optional;

public class Java8NewFeaturesTest82 {
    public static void main(String[] args) {
        String name = "tom";
        Optional<String> nameOpt = Optional.of(name);
        System.out.println(nameOpt.isPresent());
        System.out.println(nameOpt.get());

        System.out.println();

        name = null;
        try {
            nameOpt = Optional.of(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        nameOpt = Optional.ofNullable(name);
        System.out.println(nameOpt.isPresent());
        try {
            System.out.println(nameOpt.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        Optional<Object> empty = Optional.empty();

        System.out.println(empty.isPresent());

        try {
            System.out.println(empty.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * Output:
    true
    tom
    
    java.lang.NullPointerException
            at java.base/java.util.Objects.requireNonNull(Objects.java:220)
            at java.base/java.util.Optional.of(Optional.java:113)
            at Java8NewFeaturesTest82.main(Java8NewFeaturesTest82.java:14)
    
    false
    java.util.NoSuchElementException: No value present
            at java.base/java.util.Optional.get(Optional.java:143)
            at Java8NewFeaturesTest82.main(Java8NewFeaturesTest82.java:24)
    
    false
    java.util.NoSuchElementException: No value present
            at java.base/java.util.Optional.get(Optional.java:143)
            at Java8NewFeaturesTest82.main(Java8NewFeaturesTest82.java:36)
 */