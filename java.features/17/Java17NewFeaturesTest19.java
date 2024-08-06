public class Java17NewFeaturesTest19 {
        public static void main(String[] args) {
                Shape square = new Square();

                square.display();

                Class<?> clazz = square.getClass();

                System.out.println(clazz.isSealed());

                Class<?> superClazz = clazz.getSuperclass();

                System.out.println(superClazz.isSealed());

                Class<?>[] permittedSubclasses = superClazz.getPermittedSubclasses();

                for (int i = 0; i < permittedSubclasses.length; i++) {
                        System.out.println(permittedSubclasses[i]);
                }
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

        private static sealed interface Shape permits Rectangle {
                abstract void display();
        }
}