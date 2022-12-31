import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinPoolTest3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        try {
            int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

            int sum = IntStream.of(numbers).sum();

            System.out.println("sum = " + sum);

            CustomRecursiveTask task = new CustomRecursiveTask(numbers);
            System.out.println("sum by fork join = " + pool.submit(task).get());
        } finally {
            pool.shutdown();
        }

        Thread.currentThread().join();
    }

    static class CustomRecursiveTask extends RecursiveTask<Integer> {
        private int[] arr;

        private static final int THRESHOLD = 5;

        public CustomRecursiveTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        protected Integer compute() {
            if (arr.length > THRESHOLD) {
                return ForkJoinTask.invokeAll(createSubtasks())
                        .stream()
                        .mapToInt(ForkJoinTask::join)
                        .sum();
            } else {
                return processing(arr);
            }
        }

        private Collection<CustomRecursiveTask> createSubtasks() {
            List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
            dividedTasks.add(new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, 0, arr.length / 2)));
            dividedTasks.add(new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
            return dividedTasks;
        }

        private Integer processing(int[] arr) {
            return Arrays.stream(arr).sum();
        }
    }
}
