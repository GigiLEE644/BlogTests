import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;

@Inherited
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    String value() default "custom annotation";
}

@CustomAnnotation(value = "i am your father")
class Father {
}

class Child extends Father {

}

public class AnnotationTest7 extends Father {
    public static void main(String[] arg) throws Exception {
        printAnnotationState(Father.class);
        System.out.println();
        printAnnotationState(Child.class);
    }

    static void printAnnotationState(AnnotatedElement ann) {
        System.out.println(ann);

        Annotation[] annotationsArray = ann.getAnnotations();

        for (Annotation annotation : annotationsArray) {
            System.out.println(
                    "Name : "
                            + annotation.annotationType());
            System.out.println(
                    "Value : "
                            + ((CustomAnnotation) annotation).value());
        }
    }
}