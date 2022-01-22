import java.util.Random;

public class InitializationTest {
    // instance variables are not initialized in the initialization phase
    // only static class variables are
    private int a = 0;

    // A is in <clinit>()
    private static int A = 10;

    // B is not in <clinit>() bcz programmer does not initialize it explicitly
    private static int B;

    // C is in <clinit>() bcz programmer initialize its value explicitly in a static
    // block
    private static int C;
    static {
        C = 20;
    }

    // D is not in <clinit>()
    // bcz it has final modifier, so it is a constant
    // its initialization has been done at the prepare step of linking phase
    private static final int D = 30;

    // E is in <clinit>()
    // even if it has final modifier (it is a constant)
    // but its value is not primitive type
    // so at the prepare step of linking phase, it can not be defined
    // it is why it is been initialized in the initialization phase
    private static final int E = Integer.valueOf(40);

    // F is in <clinit>()
    // even if it has final modifier (it is a constant)
    // even if its value is primitive type
    // but its value needs to call method to be determined
    // so at the prepare step of linking phase, it can not be defined
    // it is why it is been initialized in the initialization phase
    private static final int F = new Random().nextInt(50);

    // G is not in <clinit>()
    // bcz it has final modifier, so it is a constant
    // even if its value is not primitive type
    // but string literal is initialized at the prepare step of linking phase
    // in constant pool of class file, we can find ConstantValue for it
    private static final String G = "hello";

    // H is in <clinit>()
    // even if it has final modifier (it is a constant)
    // but its value is not primitive type nor string literal
    // so at the prepare step of linking phase, it can not be defined
    // it is why it is been initialized in the initialization phase
    private static final String H = new String("world");
}
