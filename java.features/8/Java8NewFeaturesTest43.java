import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8NewFeaturesTest43 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 2, 4, 2 };

        display(Stream.of(nums).collect(Collectors.toMap(k -> k, v -> v * 2, (v1, v2) -> {
            System.out.println("v1 = " + v1);
            System.out.println("v2 = " + v2);
            System.out.println();
            return v1;
        })));

        System.out.println();

        display(Stream.of(nums).collect(Collectors.toMap(k -> k, v -> v * 2)));
    }

    private static void display(Map<Integer, Integer> m) {
        m.forEach((k, v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
        });
    }
}
/**
 * Output:
        v1 = 4
        v2 = 4
        
        key = 1
        value = 2
        key = 2
        value = 4
        key = 3
        value = 6
        key = 4
        value = 8
        
        Exception in thread "main" java.lang.IllegalStateException: Duplicate key 2 (attempted merging values 4 and 4)
                at java.base/java.util.stream.Collectors.duplicateKeyException(Collectors.java:135)
                at java.base/java.util.stream.Collectors.lambda$uniqKeysMapAccumulator$0(Collectors.java:182)
                at java.base/java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
                at java.base/java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:1024)
                at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:570)
                at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
                at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:723)
                at Java8NewFeaturesTest43.main(Java8NewFeaturesTest43.java:18)
 */