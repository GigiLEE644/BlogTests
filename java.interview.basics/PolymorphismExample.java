public class PolymorphismExample {
    // Superclass
    private static class Animal {
        public void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    // Subclass 1
    private static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
    }

    // Subclass 2
    private static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        Animal myAnimal;

        myAnimal = new Dog();
        myAnimal.makeSound();  // Output: Woof!

        myAnimal = new Cat();
        myAnimal.makeSound();  // Output: Meow!
    }
}
/*
 * Output :
 * 
 * Woof!
 * Meow!
 */