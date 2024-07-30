import java.lang.reflect.RecordComponent;

public class Java17NewFeaturesTest14 {

        public static void main(String[] args) {
                Person tom = new Person("tom", 18);

                System.out.println(tom);
                System.out.println();

                Class<?> clazz = tom.getClass();

                if (clazz.isRecord()) {
                        RecordComponent[] components = clazz.getRecordComponents();

                        for (int i = 0; i < components.length; i++) {
                                System.out.println(components[i]);
                                System.out.println(components[i].getType());
                                System.out.println(components[i].getName());
                                System.out.println();
                        }
                }
        }

        private static record Person(String name, int age) {
        }
}