public class Java17NewFeaturesTest5 {

        public static void main(String[] args) {
                Person tom = new Person("tom", 18);

                System.out.println(tom);
                System.out.println(tom.name());
                System.out.println(tom.age());

                System.out.println();

                Person tom2 = new Person("tom", 18);

                System.out.println(tom == tom2);
                System.out.println(tom.equals(tom2));

                System.out.println();

                Person jerry = new Person("jerry", 16);

                System.out.println(tom == jerry);
                System.out.println(tom.equals(jerry));
        }

        private static record Person(String name, int age) {
        }
}