import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Person p = new Person(1, "tom");

        Map<Person, Integer> map = new HashMap<>();

        map.put(p, 100);

        System.out.println("Size of HashMap before setting key to null : " + map.size());

        p = null;

        System.gc();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("Size of HashMap after setting key to null : " + map.size());

        System.out.println();

        map = new WeakHashMap<>();

        p = new Person(2, "jerry");

        map.put(p, 100);

        System.out.println("Size of WeakHashMap before setting key to null : " + map.size());

        p = null;

        System.gc();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("Size of WeakHashMap after setting key to null : " + map.size());
    }

    private static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            if (id != other.id)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Person [id=" + id + ", name=" + name + "]";
        }
    }
}
