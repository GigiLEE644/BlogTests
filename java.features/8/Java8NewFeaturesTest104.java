import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Java8NewFeaturesTest104 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        iterateUsingIterator(numbers);

        System.out.println();

        iterateUsingEnhancedForLoop(numbers);

        System.out.println();

        iterateUsingForEachLoop(numbers);

        System.out.println();

        removeElementsUsingIterator(numbers);

        System.out.println(numbers.size());
    }

    public static void iterateUsingIterator(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void iterateUsingEnhancedForLoop(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public static void iterateUsingForEachLoop(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }

    public static void removeElementsUsingIterator(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}