public class Java25NewFeaturesTest1 {
    public static void main(String[] args) {
        Object obj = 42;

        switch (obj) {
            case Integer i -> System.out.println("It's an int: " + i);
            case Long l -> System.out.println("It's a long: " + l);
            case Double d -> System.out.println("It's a double: " + d);
            default -> System.out.println("Unknown type");
        }
    }
}
/*
 * Output: It's an int: 42
 */
