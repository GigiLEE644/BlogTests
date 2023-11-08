public class AnnotationTest1 {
    public static void main(String[] args) {
        Person tom = new Student(1, "tom", 18);

        tom.greeting();
    }

    private static class Person {
        protected String name;
        protected int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void greeting() {
            System.out.println("hello my name is " + this.name + " and i am " + this.age + " years old");
        }
    }

    private static class Student extends Person {
        private int id;

        Student(int id, String name, int age) {
            super(name, age);
            this.id = id;
        }

        @Override
        public void greeting() {
            super.greeting();
            System.out.println("my id is " + this.id);
        }
    }
}
