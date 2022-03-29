import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    /**
     * -Xms10m -Xmx10m
     */
    public static void main(String[] args) throws InterruptedException {

        SoftReference<Person> p = new SoftReference<>(new Person("tom", 18));
        // Above line equals to below three lines
        // 1.declare person object; 2. associate with soft reference;
        // 3. disable strong reference)
        // Person tom = new Person("tom", 18);
        // SoftReference<Person> p = new SoftReference<>(tom);
        // tom = null;

        System.out.println(p.get());

        System.gc();
        Thread.currentThread().sleep(3000);

        System.out.println();
        System.out.println("After gc, when memory is still enough :");

        System.out.println(p.get());

        byte[] bigObject = new byte[1024 * 1024 * 7];
        byte[] notSoBigObject = new byte[512];

        System.out.println();
        System.out.println("After gc, when memory is not enough :");

        System.out.println(p.get());

    }

    private static class Person {
        private String name;
        private int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person [age=" + age + ", name=" + name + "]";
        }
    }
}