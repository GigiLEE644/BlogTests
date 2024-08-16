public class Java21NewFeaturesTest1 {

        public static void main(String[] args) {
                Person p = new Person(new Name("hello", "world"), 1);
                display(p);
                display2(p);
                display3(p);
        }

        private static void display(Object obj) {
                if (obj instanceof Person p) {
                        System.out.println("first name = " + p.name().first());
                        System.out.println("last name = " + p.name().last());
                        System.out.println("age = " + p.age());
                }

                System.out.println(obj);
                System.out.println();
        }

        private static void display2(Object obj) {
                if (obj instanceof Person(Name(String first, String last), int age)) {
                        System.out.println("first name = " + first);
                        System.out.println("last name = " + last);
                        System.out.println("age = " + age);
                }

                System.out.println(obj);
                System.out.println();
        }

        private static void display3(Object obj) {
                if (obj instanceof Person(Name(var first, var last), var age)) {
                        System.out.println("first name = " + first);
                        System.out.println("last name = " + last);
                        System.out.println("age = " + age);
                }

                System.out.println(obj);
                System.out.println();
        }

        record Name(String first, String last) {

        }

        record Person(Name name, int age) {
        }
}