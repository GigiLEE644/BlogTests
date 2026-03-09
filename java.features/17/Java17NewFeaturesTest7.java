import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.RecordComponent;

public class Java17NewFeaturesTest7 {

        public static void main(String[] args) throws NoSuchFieldException, SecurityException {
                Person tom = new Person("tom", 18);

                System.out.println(tom);
                System.out.println(tom.name());
                System.out.println(tom.age());

                for (Annotation annotation : tom.getClass().getDeclaredAnnotations()) {
                        System.out.println(annotation);
                }

                for (RecordComponent recordComponents : tom.getClass().getRecordComponents()) {
                        for (Annotation annotation : recordComponents.getDeclaredAnnotations()) {
                                System.out.println(annotation);
                        }
                }
        }

        @MyRecordAnnotation("this is a person")
        private static record Person(@MyRecordComponentAnnotation("this is the name of the person") String name,
                        int age) {
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target({ ElementType.TYPE })
        public @interface MyRecordAnnotation {
                String value();
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target({ ElementType.RECORD_COMPONENT })
        public @interface MyRecordComponentAnnotation {
                String value();
        }
}
/**
 * Output:
 *       Person[name=tom, age=18]
 *       tom
 *       18
 *       @Java17NewFeaturesTest7$MyRecordAnnotation(value=this is a person)
 *       @Java17NewFeaturesTest7$MyRecordComponentAnnotation(value=this is the name of the person)
 */