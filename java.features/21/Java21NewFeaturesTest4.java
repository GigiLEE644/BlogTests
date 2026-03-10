import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest4 {

        public static void main(String[] args) {
                List<Integer> nums = new ArrayList<>() {
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

        private static void display(List<Integer> l) {
                int n = l.size();

                for (int i = 0; i < n; i++) {
                        System.out.print(l.get(i));

                        if (i != n - 1) {
                                System.out.print(",");
                        }
                }

                System.out.println();
        }
}
/**
 * Output:
        0,1,2,3,4,5,6,7,8,9
        9,8,7,6,5,4,3,2,1,0
        0
        9
        -1,0,1,2,3,4,5,6,7,8,9,10
        0,1,2,3,4,5,6,7,8,9
 */