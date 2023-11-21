import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationTest8 {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyMethodAnnotation {
        public String title() default "";

        public String description() default "";
    }

    private static class TestMethodAnnotation {
        @MyMethodAnnotation(title = "test method", description = "this is for testing MyMethodAnnotation")
        public static void test() {

        }
    }

    public static void main(String[] args) {
        try {
            Method[] methods = TestMethodAnnotation.class.getDeclaredMethods();

            for (Method method : methods) {
                for (Annotation anno : method.getDeclaredAnnotations()) {
                    if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                        System.out.println("Annotation in Method '"
                                + method + "' : " + anno);

                        MyMethodAnnotation methodAnno = method
                                .getAnnotation(MyMethodAnnotation.class);

                        System.out.println("title = " + methodAnno.title());
                        System.out.println("description = " + methodAnno.description());
                    }

                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}