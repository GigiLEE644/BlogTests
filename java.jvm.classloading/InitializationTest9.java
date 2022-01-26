import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class InitializationTest9 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream fi = new FileInputStream(new File("a"));
                ObjectInputStream oi = new ObjectInputStream(fi)) {
            A a = (A) oi.readObject();
        }
    }

    private static class A implements Serializable {
        static {
            System.out.println("A has been initialized!");
        }
    }
}
// private static void serialize() throws IOException, FileNotFoundException {
// A a = new A();

// try (FileOutputStream f = new FileOutputStream(new File("a"));
// ObjectOutputStream o = new ObjectOutputStream(f)) {
// o.writeObject(a);
// }
// }