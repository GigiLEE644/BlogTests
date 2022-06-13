import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerializationAndDeserialization {
    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        String path = "/home/yan/github/BlogTests/tom.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(new Person("tom", 18));
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Person p = (Person) ois.readObject();
            System.out.println(p);
        }
    }

    private static class Person implements Serializable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [age=" + age + ", name=" + name + "]";
        }
    }
}
