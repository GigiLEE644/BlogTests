import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class ForkJoinPoolTest2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        try {
            int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            CustomRecursiveAction action = new CustomRecursiveAction(numbers);
            pool.execute(action);
        } finally {
            pool.shutdown();
        }

        Thread.currentThread().join();
    }

    static class CustomRecursiveAction extends RecursiveAction {
        private int[] arr;

        private static final int THRESHOLD = 3;

        public CustomRecursiveAction(int[] arr) {
            this.arr = arr;
        }

        @Override
        protected void compute() {
            if (arr.length > THRESHOLD) {
                ForkJoinTask.invokeAll(createSubtasks());
            } else {
                processing(arr);
            }
        }

        private List<CustomRecursiveAction> createSubtasks() {
            List<CustomRecursiveAction> subtasks = new ArrayList<>();

            subtasks.add(new CustomRecursiveAction(
                    Arrays.copyOfRange(arr, 0, arr.length / 2)));
            subtasks.add(new CustomRecursiveAction(
                    Arrays.copyOfRange(arr, arr.length / 2, arr.length)));

            return subtasks;
        }

        private void processing(int[] arr) {
            IntStream.of(arr).forEach(System.out::println);
        }
    }
}
