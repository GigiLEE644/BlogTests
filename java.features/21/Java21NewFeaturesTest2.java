public class Java21NewFeaturesTest2 {

        public static void main(String[] args) {
                Animal dog = new Dog();

                System.out.println("Dog goes : " + makeSound(dog));

                Animal cat = new Cat();

                System.out.println("Cat goes : " + makeSound(cat));

                System.out.println(makeSound(null));
        }

        private static interface Animal {

        }

        private static class Dog implements Animal {

        }

        private static class Cat implements Animal {

        }

        private static String makeSound(Animal animal) {
                return switch (animal) {
                        case Dog dog -> "woof";
                        case Cat cat -> "meow";
                        case null, default -> "???";
                };
        }
}