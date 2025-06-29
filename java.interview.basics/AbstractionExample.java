public class AbstractionExample {
    private static abstract class Animal {
        // Abstract method - no body
        public abstract void makeSound();

        // Concrete method
        public void sleep() {
            System.out.println("Sleeping...");
        }
    }

    private static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
    }

    public static void main(String[] args) {
        // Create a Dog object
        Animal myDog = new Dog();

        // Call the abstract method
        myDog.makeSound(); // Output: Woof!

        // Call the concrete method
        myDog.sleep(); // Output: Sleeping...
    }
}
/*
 * Output :
 * 
 * Woof!
 * Sleeping...
 */