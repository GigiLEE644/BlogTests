import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class Java8NewFeaturesTest101 {
    @Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExpectedType {
        public Class<?> value();
    }

    public static class CustomStringUtils {
        public @ExpectedType(String.class) String convertCase(@ExpectedType(String.class) String s,
                @ExpectedType(boolean.class) boolean toUpperCase) {
            return toUpperCase ? s.toUpperCase() : s.toLowerCase();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Method m = CustomStringUtils.class.getMethod("convertCase", String.class, boolean.class);

        AnnotatedType returnType = m.getAnnotatedReturnType();
        Annotation returnTypeAnnotation = returnType.getAnnotation(ExpectedType.class);
        System.out.println("returnTypeAnnotation :");
        System.out.println(returnTypeAnnotation);
        System.out.println();

        AnnotatedType[] parameters = m.getAnnotatedParameterTypes();
        System.out.println("parametersAnnotation :");
        for (AnnotatedType p : parameters) {
            Annotation parameterAnnotation = p.getAnnotation(ExpectedType.class);
            System.out.println(parameterAnnotation);
        }
    }
}