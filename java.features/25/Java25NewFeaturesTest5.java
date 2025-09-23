import java.util.function.Supplier;

public class Java25NewFeaturesTest5 {
    // StableValue declared but not initialized yet
    static Supplier<String> greeting = StableValue.supplier(() -> {
        System.out.println("Initializing greeting...");
        return "Hello, stable world!";
    }
    );

    void main() {
        System.out.println("Program started");

        // Nothing initialized yet
        System.out.println("Has it initialized? Not until get() is called!");

        // First call to get() → triggers initialization
        System.out.println("Greeting: " + greeting.get());

        // Second call to get() → reuses the cached value, no re-initialization
        System.out.println("Greeting again: " + greeting.get());
    }
}
/* Output:
        Program started
        Has it initialized? Not until get() is called!
        Initializing greeting...
        Greeting: Hello, stable world!
        Greeting again: Hello, stable world!
*/