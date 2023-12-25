import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericsTest25 {
    public static void main(String[] args) {
        StringContainer c = new StringContainer();

        c.setValue("hello");

        System.out.println(c.getValue());

        ParameterizedType superClass = (ParameterizedType) c.getClass().getGenericSuperclass();

        System.out.println(superClass.getTypeName());
        System.out.println(superClass.getRawType());

        Type[] actualTypeArguments = superClass.getActualTypeArguments();

        for (int i = 0; i < actualTypeArguments.length; i++) {
            Type type = actualTypeArguments[i];
            System.out.println(type);
        }
    }

    private static class Container<T> {
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private static class StringContainer extends Container<String> {

    }
}
