public class ClassTest5 {
    public static void main(String[] args) {
        Duck duck = new Duck();

        duck.speak();
        duck.fly();
        duck.swim();

        System.out.println();

        Class<?>[] interfaces = duck.getClass().getInterfaces();

        for (Class<?> intf : interfaces) {
            System.out.println(intf.getName());
        }
    }

    private interface Animal {
        void speak();
    }

    private interface Swimmable {
        void swim();
    }

    private interface Flyable {
        void fly();
    }

    private static class Duck implements Animal, Swimmable, Flyable {
        @Override
        public void speak() {
            System.out.println("Quack");
        }

        @Override
        public void fly() {
            System.out.println(this.getClass().getSimpleName() + " flying");
        }

        @Override
        public void swim() {
            System.out.println(this.getClass().getSimpleName() + " swimming");
        }
    }
}
