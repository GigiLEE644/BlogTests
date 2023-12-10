import java.util.ArrayList;
import java.util.List;

public class GenericsTest12 {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        // Type mismatch : cannot convert from List<Dog> to List<Animal>
        // List<Animal> animals = dogs;

        List<? super Dog> animals = dogs;

        System.out.println(animals == dogs);
    }

    private static class Animal {

    }

    private static class Dog extends Animal {

    }
}
