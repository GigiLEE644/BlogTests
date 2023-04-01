import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        Person p1 = new Person(1, "tom");
        Person p2 = new Person(1, "tom");

        HashMap<Person, Integer> hmap = new HashMap<>();

        hmap.put(p1, 100);
        hmap.put(p2, 200);

        System.out.println("Number of elements in hash map : " + hmap.size());

        for (Person p : hmap.keySet()) {
            System.out.println(p + " : " + hmap.get(p));
        }

        System.out.println();

        IdentityHashMap<Person, Integer> imap = new IdentityHashMap<>();

        imap.put(p1, 100);
        imap.put(p2, 200);

        System.out.println("Number of elements in identity hash map : " + imap.size());

        for (Person p : imap.keySet()) {
            System.out.println(p + " : " + imap.get(p));
        }

        System.out.println();

        p1.name = "jerry";

        System.out.println(hmap.containsKey(p1));
        System.out.println(imap.containsKey(p1));
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
