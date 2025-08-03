public class FinalReferenceVariable {
    public static void main(String[] args) {
        final Person person = new Person("tom");
        System.out.println(person.name);
        person.name = "jerry";
        System.out.println(person.name);
    }

    private static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}