import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest23 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Person p = new Person("tom", 18);

        Class<?> clazz = p.getClass();

        Method method = clazz.getDeclaredMethod("speak", String.class);

        for (Annotation[] annotations : method.getParameterAnnotations()) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof Punctuation) {
                    String punctuation = ((Punctuation) annotation).value();

                    method.invoke(p, "hello world");
                    System.out.print(punctuation);
                }
            }
        }
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void speak(@Punctuation(".\n") String words) {
            System.out.print(this + " : " + words);
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    private static @interface Punctuation {
        public String value();
    }
}
