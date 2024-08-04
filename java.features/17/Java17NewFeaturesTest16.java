public class Java17NewFeaturesTest16 {

        public static void main(String[] args) {
                Shape rectangle = new Rectangle();

                rectangle.display();
        }

        /*
         * private static final class Circle extends Shape {
         * 
         * @Override
         * void display() {
         * System.out.println("I am a circle");
         * }
         * 
         * }
         */
        private static final class Rectangle extends Shape {
                @Override
                void display() {
                        System.out.println("I am a rectangle");
                }

        }

        private static abstract sealed class Shape permits Rectangle {
                abstract void display();
        }
}