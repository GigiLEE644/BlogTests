import java.util.Arrays;
import java.util.List;

public class Java17NewFeaturesTest6 {

        public static void main(String[] args) {
                Person<String> tom = new Person<String>("tom", 18, Arrays.asList("java", "c++"));

                System.out.println(tom);
                System.out.println(tom.name());
                System.out.println(tom.age());
                System.out.println(tom.skills());
        }

        private static record Person<T>(String name, int age, List<T> skills) {
        }
}