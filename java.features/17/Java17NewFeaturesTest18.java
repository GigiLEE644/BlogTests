public class Java17NewFeaturesTest18 {
        public static void main(String[] args) {
                Shape rectangle = new Rectangle();

                rectangle.display();

                Shape square = new Square();

                square.display();

                Shape oval = new Oval();

                oval.display();

                Shape circle = new Circle();

                circle.display();
        }

        private static final class Square extends Rectangle {
                @Override
                public void display() {
                        System.out.println("I am a square");
                }
        }

        private static sealed class Rectangle implements Shape permits Square {
                @Override
                public void display() {
                        System.out.println("I am a rectangle");
                }
        }

        private static non-sealed class Oval implements Shape {
                @Override
                public void display() {
                        System.out.println("I am a oval");
                }

        }

        private static class Circle extends Oval {
                @Override
                public void display() {
                        System.out.println("I am a circle");
                }
        }

        private static sealed interface Shape permits Rectangle, Oval {
                abstract void display();
        }
}