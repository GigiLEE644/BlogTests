public class Java17NewFeaturesTest17 {
        public static void main(String[] args) {
                Shape rectangle = new Rectangle();

                rectangle.display();
        }

        private static final class Rectangle implements Shape {
                @Override
                public void display() {
                        System.out.println("I am a rectangle");
                }

        }

        private static sealed interface Shape permits Rectangle {
                void display();
        }
}