public class Java11NewFeaturesTest1 {

    public static void main(String[] args) {
        System.out.println("".isBlank());
        System.out.println("\t".isBlank());
        System.out.println("\n".isBlank());

        System.out.println("**********");

        System.out.println(" hello world ".strip() + "!");
        System.out.println("\thello world\t".strip() + "!");
        System.out.println("\nhello world\n".strip() + "!");

        System.out.println("**********");

        System.out.println(" hello world ".stripLeading() + "!");
        System.out.println("\thello world\t".stripLeading() + "!");
        System.out.println("\nhello world\n".stripLeading() + "!");

        System.out.println("**********");

        System.out.println(" hello world ".stripTrailing() + "!");
        System.out.println("\thello world\t".stripTrailing() + "!");
        System.out.println("\nhello world\n".stripTrailing() + "!");

        System.out.println("**********");

        System.out.println("hello world".repeat(2));
        System.out.println("hello world".repeat(0));
        System.out.println("hello world".repeat(1));

        System.out.println("**********");

        "hello\nworld\n".lines().forEach(System.out::println);
    }
}