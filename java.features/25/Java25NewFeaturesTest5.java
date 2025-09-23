public class Java25NewFeaturesTest5 {
    // Create a StableValue holding an immutable String
    static final StableValue<String> MESSAGE = StableValue.of("Hello, StableValue!");

    void main() {
        System.out.println(MESSAGE); // Output: Hello, StableValue!
    }
}