import java.util.stream.Stream;

public class Java8NewFeaturesTest39 {
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 4, 2 };

        Object[] arr = Stream.of(nums).toArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println();

        Integer[] iarr = Stream.of(nums).toArray(size -> new Integer[size]);

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }

        System.out.println();

        Integer[] iarray = Stream.of(nums).toArray(Integer[]::new);

        for (int i = 0; i < iarray.length; i++) {
            System.out.println(iarray[i]);
        }
    }
}
