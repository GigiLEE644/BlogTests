public class LocalVariablesTest {
    public static void main(String[] args) {
        String greeting = "hello world";

        LocalVariablesTest test = new LocalVariablesTest();

        test.sayHi(greeting);
    }

    private void sayHi(String greeting) {
        System.out.println(greeting);
    }
}
