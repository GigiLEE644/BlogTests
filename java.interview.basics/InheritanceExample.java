public class InheritanceExample {
    // Superclass
    private static class Animal {
        public void eat() {
            System.out.println("This animal eats food.");
        }

        public void sleep() {
            System.out.println("This animal sleeps.");
        }
    }

    // Subclass
    private static class Dog extends Animal {
        public void bark() {
            System.out.println("The dog barks.");
        }

        // Overriding the eat method
        @Override
        public void eat() {
            System.out.println("The dog eats bones.");
        }
    }

    public static void main(String[] args) {
        Dog myDog = new Dog();

        // Inherited methods
        myDog.sleep(); // From Animal
        myDog.eat(); // Overridden in Dog

        // Dog's own method
        myDog.bark();
    }
}

/*
 * Output :
 * 
 *  This animal sleeps.
 *  The dog eats bones.
 *  The dog barks.
 */