import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Java8NewFeaturesTest5 {
    public static void main(String[] args) {
        draw("Euro Millions", () -> new Lottery(50, 7).shuffle());

        draw("Loto", () -> new Lottery(49, 6).shuffle());
    }

    private static void draw(String lottery, Supplier<List<Integer>> s) {
        List<Integer> result = s.get();

        System.out.println(lottery);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    private static class Lottery {
        private int total;
        private int winning;
        private List<Integer> numbers;

        Lottery(int total, int winning) {
            this.total = total;
            this.winning = winning;
            this.numbers = new ArrayList<>(total);

            for (int i = 1; i <= this.total; i++) {
                this.numbers.add(i);
            }
        }

        List<Integer> shuffle() {
            Collections.shuffle(this.numbers);

            List<Integer> nums = new ArrayList<>();

            for (int i = 0; i < this.winning; i++) {
                nums.add(this.numbers.get(i));
            }

            return nums;
        }
    }
}
