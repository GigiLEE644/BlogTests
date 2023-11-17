import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationTest4 {
    @Retention(RetentionPolicy.SOURCE)
    @interface SourceRetention {
        String value() default "Source Retention";
    }

    @Retention(RetentionPolicy.CLASS)
    @interface ClassRetention {
        String value() default "Class Retention";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface RuntimeRetention {
        String value() default "Runtime Retention";
    }

    @SourceRetention
    private static class A {

    }

    @ClassRetention
    private static class B {

    }

    @RuntimeRetention
    private static class C {

    }

    public static void main(String[] args) {
        Annotation a[] = new A().getClass().getAnnotations();
        Annotation b[] = new B().getClass().getAnnotations();
        Annotation c[] = new C().getClass().getAnnotations();

        System.out.println(
                "Number of annotations attached to "
                        + "class A at Runtime: " + a.length);

        System.out.println(
                "Number of annotations attached to "
                        + "class B at Runtime: " + b.length);

        System.out.println(
                "Number of annotations attached to "
                        + "class C at Runtime: " + c.length);
    }
}