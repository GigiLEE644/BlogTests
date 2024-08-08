import java.util.HashMap;
import java.util.Map;

public class Java17NewFeaturesTest22 {
        public static void main(String[] args) {
                Map<Integer, Employee> employees = new HashMap<>() {
                        {
                                put(1, new Employee(1, "tom", 18));
                                put(2, new Employee(2, null, 16));
                        }
                };

                System.out.println(employees.get(1).name().toUpperCase());

                try {
                        System.out.println(employees.get(2).name().toUpperCase());
                } catch (Exception e) {
                        e.printStackTrace();
                }

                System.out.println();

                try {
                        System.out.println(employees.get(3).name().toUpperCase());
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        private static record Employee(int id, String name, int age) {

        }
}