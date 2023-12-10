public class GenericsTest10 {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Animal animal = dog;

        System.out.println(dog == animal);
    }

    private static class Animal {

    }

    private static class Dog extends Animal {

    }
}