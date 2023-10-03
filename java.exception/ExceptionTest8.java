public class ExceptionTest8 {
    public static void main(String[] args) {
        try {
            System.out.println("I am in try block");

            int x = 1 / 0;

            System.out.println("This line will not be printed");
        } finally {
            System.out.println("I am in finally block");
        }

        System.out.println("This line will not be printed");
    }
}