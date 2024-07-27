public class Java17NewFeaturesTest8 {

        public static void main(String[] args) {
                try {
                        new Person("", 18);
                } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                }

                System.out.println();

                try {
                        new Person("tom", 0);
                } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                }

                System.out.println();

                Person tom = new Person("tom", 18);

                System.out.println(tom);

        }

        private static record Person(String name, int age) {
                Person(String name, int age) {
                        if (name == null || name.trim().isEmpty()) {
                                throw new IllegalArgumentException("name is required");
                        }

                        if (age <= 0) {
                                throw new IllegalArgumentException("age should >= 1");
                        }

                        this.name = name;
                        this.age = age;
                }
        }
}