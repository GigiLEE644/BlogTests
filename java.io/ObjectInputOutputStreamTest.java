import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputOutputStreamTest {
    private static class Person implements Serializable {
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "/home/yan/github/BlogTests/person";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeInt(2);

            oos.writeObject(new Person("tom", 18, true));
            oos.writeObject(new Person("jerry", 16, true));
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            int num = ois.readInt();

            for (int i = 0; i < num; i++) {
                Person p = (Person) ois.readObject();
                System.out.println(p);
            }
        }
    }
}
