import java.util.LinkedHashMap;
import java.util.Map;

public class Java21NewFeaturesTest6 {

        public static void main(String[] args) {
                LinkedHashMap<String, String> persons = new LinkedHashMap<>() {
                        {
                                put("tom", "cat");
                                put("jerry", "mouse");
                                put("mickey", "mouse");
                                put("donald", "duck");
                        }
                };

                display(persons);

                display(persons.reversed());

                display(persons.firstEntry());
                display(persons.lastEntry());

                System.out.println();

                persons.putFirst("scrooge", "duck");
                persons.putLast("goofy", "dog");

                display(persons);

                display(persons.pollFirstEntry());
                display(persons.pollLastEntry());

                System.out.println();

                display(persons);
        }

        private static void display(Map<String, String> m) {
                for (Map.Entry<String, String> e : m.entrySet()) {
                        display(e);
                }
                System.out.println();
        }

        private static void display(Map.Entry<String, String> e) {
                System.out.println(e.getKey() + " : " + e.getValue());
        }
}