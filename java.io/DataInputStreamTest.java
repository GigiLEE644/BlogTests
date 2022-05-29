import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamTest {
    private static class Person {
        private String name;
        private int age;
        private boolean male;

        public Person(String name, int age, boolean male) {
            this.name = name;
            this.age = age;
            this.male = male;
        }

        @Override
        public String toString() {
            return "Person [age=" + age + ", male=" + male + ", name=" + name + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        Person p1 = new Person("tom", 18, true);
        Person p2 = new Person("jerry", 16, true);
        Person p3 = new Person("toodles galore", 15, false);

        
    }
}
