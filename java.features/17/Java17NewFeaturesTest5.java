public class Java17NewFeaturesTest5 {

        public static void main(String[] args) {
                Person tom = new Person("tom", 18);

                System.out.println(tom);
                System.out.println(tom.name());
                System.out.println(tom.age());
        }

        private static record Person(String name, int age) {
        }
}