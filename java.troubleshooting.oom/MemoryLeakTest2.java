import java.util.HashMap;
import java.util.Map;

public class MemoryLeakTest2 {
    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            map.put(new Person("tom", 18), 1);
        }

        // map should only contain one (k,v) = ((tom,18),1)
        // but it is not the case, there are 3 which cause a memory leak
        System.out.println(map.size());
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
/**
 * Output:
 *  3
 */