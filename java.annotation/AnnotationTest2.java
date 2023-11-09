public class AnnotationTest2 {
    public static void main(String[] args) {
        Person jerry = new Person("jerry", 16);
        jerry.greeting();
    }

    private static class Person {
        protected String name;
        protected int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Deprecated
        public void greeting() {
            System.out.println("hello my name is " + this.name + " and i am " + this.age + " years old");
        }
    }
}
