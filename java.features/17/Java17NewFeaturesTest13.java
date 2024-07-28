import java.util.ArrayList;
import java.util.List;

public class Java17NewFeaturesTest13 {

        public static void main(String[] args) {
                List<String> skills = new ArrayList<>() {
                        {
                                add("java");
                                add("c++");
                        }
                };

                Person<String> tom = new Person<String>("tom", 18, skills);

                display(tom);

                skills.add("c#");

                display(tom);

                try {
                        tom.skills().add("c");
                } catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                        System.out.println();
                }

                display(tom);
        }

        private static void display(Person<String> tom) {
                System.out.println(tom);
                System.out.println(tom.name());
                System.out.println(tom.age());
                System.out.println(tom.skills());
                System.out.println(tom.hashCode());
                System.out.println();
        }

        private static record Person<T>(String name, int age, List<T> skills) {
                @SuppressWarnings("unchecked")
                Person {
                        skills = (List<T>) List.of(skills.toArray());
                }
        }
}