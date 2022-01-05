import java.util.HashMap;
import java.util.Map;

public class MemoryLeakTest3 {
    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<>();

        Person p = new Person("tom", 18);

        map.put(p, 1);

        // comment below line will make map size = 1
        p.age = 16;

        map.put(p, 1);

        System.out.println(map.size());
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
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
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
    }
}
