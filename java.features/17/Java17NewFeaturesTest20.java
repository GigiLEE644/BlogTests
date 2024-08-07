import java.util.ArrayList;
import java.util.List;

public class Java17NewFeaturesTest20 {
        public static void main(String[] args) {
                List<Animal> animals = new ArrayList<>() {
                        {
                                add(new Cat());
                                add(new Dog());
                        }
                };

                animals.stream().forEach((Animal animal) -> {
                        if (animal instanceof Cat) {
                                Cat cat = (Cat) animal;
                                cat.moew();
                        }

                        if (animal instanceof Dog) {
                                Dog dog = (Dog) animal;
                                dog.woof();
                        }
                });
        }

        private static interface Animal {

        }

        private static class Cat implements Animal {
                void moew() {
                        System.out.println("I am a cat");
                }
        }

        private static class Dog implements Animal {
                void woof() {
                        System.out.println("I am a dog");
                }
        }
}