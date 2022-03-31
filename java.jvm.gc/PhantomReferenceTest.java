import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        Person tom = new Person("tom", 18);
        Person jerry = new Person("jerry", 16);

        ReferenceQueue<Person> queue = new ReferenceQueue<>();

        PhantomReference<Person> r1 = new PhantomReference<Person>(tom, queue);
        PhantomReference<Person> r2 = new PhantomReference<Person>(jerry, queue);

        System.out.println("Can not get tom through panthom reference : " + r1.get());
        System.out.println("Can not get jerry through panthom reference : " + r2.get());

        tom = null;
        jerry = null;

        System.gc();

        Thread.sleep(3000);

        Reference<? extends Person> ref;
        while ((ref = queue.poll()) != null) {
            if (r1 == ref) {
                System.out.println("tom has been recycled");
            }

            if (r2 == ref) {
                System.out.println("jerry has been recycled");
            }
        }
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