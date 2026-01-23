import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Java8NewFeaturesTest6 {
    public static void main(String[] args) {
        List<Object[]> users = new ArrayList<>();

        users.add(new Object[] { "tom", 18 });
        users.add(new Object[] { "jerry", 16 });
        users.add(new Object[] { "spike", 21 });
        users.add(new Object[] { "tyke", 6 });

        Function<List<Object[]>, List<Person>> f1 = l -> {
            List<Person> p = new ArrayList<>();

            for (Object[] o : l) {
                p.add(new Person((String) o[0], (int) o[1]));
            }

            return p;
        };

        Function<List<Person>, List<Person>> f2 = l -> {
            l.sort((p1, p2) -> {
                return p1.age > p2.age ? 1 : p1.age == p2.age ? 0 : -1;
            });

            return l;
        };

        System.out.println();
        System.out.println("Original List :");

        for (Person person : f1.apply(users)) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println("Sorted List by using andThen :");

        for (Person person : f1.andThen(f2).apply(users)) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println("Sorted List by using compose :");

        for (Person person : f2.compose(f1).apply(users)) {
            System.out.println(person);
        }
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
/**
 * Output :
 * 
 * Original List :
        Person [name=tom, age=18]
        Person [name=jerry, age=16]
        Person [name=spike, age=21]
        Person [name=tyke, age=6]
        
        Sorted List by using andThen :
        Person [name=tyke, age=6]
        Person [name=jerry, age=16]
        Person [name=tom, age=18]
        Person [name=spike, age=21]
        
        Sorted List by using compose :
        Person [name=tyke, age=6]
        Person [name=jerry, age=16]
        Person [name=tom, age=18]
        Person [name=spike, age=21]
 */