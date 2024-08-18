import java.util.LinkedHashSet;
import java.util.Set;

public class Java21NewFeaturesTest5 {

        public static void main(String[] args) {
                LinkedHashSet<Integer> nums = new LinkedHashSet<>() {
                        {
                                for (int i = 0; i < 10; i++) {
                                        add(i);
                                }
                        }
                };

                display(nums);

                display(nums.reversed());

                System.out.println(nums.getFirst());
                System.out.println(nums.getLast());

                nums.addFirst(-1);
                nums.addLast(10);

                display(nums);

                nums.removeFirst();
                nums.removeLast();

                display(nums);
        }

        private static void display(Set<Integer> s) {
                int n = s.size();

                int index = 0;

                for (Integer i : s) {
                        System.out.print(i);

                        if (index != n - 1) {
                                System.out.print(",");
                        }

                        index += 1;
                }

                System.out.println();
        }
}