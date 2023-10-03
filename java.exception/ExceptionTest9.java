public class ExceptionTest9 {
    public static void main(String[] args) {
        try {
            System.out.println("I am in try block");

            int x = 4 / 2;

            System.out.println(x);
        } finally {
            System.out.println("I am in finally block");
        }

        System.out.println("The end of program");
    }
}