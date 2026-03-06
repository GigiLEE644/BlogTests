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
/**
 * Output:
        Person[name=tom, age=18]
        tom
        18

        javap -p Java17NewFeaturesTest5\$Person.class 

        Compiled from "Java17NewFeaturesTest5.java"
        final class Java17NewFeaturesTest5$Person extends java.lang.Record {
                private final java.lang.String name;
                private final int age;
                private Java17NewFeaturesTest5$Person(java.lang.String, int);
                public final java.lang.String toString();
                public final int hashCode();
                public final boolean equals(java.lang.Object);
                public java.lang.String name();
                public int age();
}
 */