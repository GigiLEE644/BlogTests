import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericsTest26 {
    public static void main(String[] args) {
        StringFunc func = new StringFunc();

        System.out.println(func.apply("hello"));

        Type[] genericInterfaces = func.getClass().getGenericInterfaces();

        for (int i = 0; i < genericInterfaces.length; i++) {
            ParameterizedType type = (ParameterizedType) genericInterfaces[i];

            System.out.println(type.getTypeName());
            System.out.println(type.getRawType());

            Type[] actualTypeArguments = type.getActualTypeArguments();

            for (int j = 0; j < actualTypeArguments.length; j++) {
                System.out.println(actualTypeArguments[j]);
            }
        }
    }

    private static interface Func<T> {
        T apply(T value);
    }

    private static class StringFunc implements Func<String> {
        @Override
        public String apply(String value) {
            return value;
        }

    }
}
