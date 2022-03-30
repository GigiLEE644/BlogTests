import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<Person> p = new WeakReference<>(new Person("tom", 18));

        System.out.println(p.get());

        System.gc();

        Thread.currentThread().sleep(3000);

        System.out.println("After gc, no matter if memory is sufficient");

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
