public class Java17NewFeaturesTest1 {

    public static void main(String[] args) {
        String person = """
                {
                    "name": "tom",
                    "age": 18
                }
                """;

        System.out.println(person);

        String escaped = """
                Text blocks start with a \""" (three double-quote marks) followed by optional whitespaces and a newline.
                """;

        System.out.println(escaped);

        String formated = """
                hi, my name is %s.
                """.formatted("tom");

        System.out.println(formated);
    }
}