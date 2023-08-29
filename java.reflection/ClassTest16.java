import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest16 {
    public static void main(String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {
        Box<Integer> box = new Box<Integer>();

        Method method = null;

        try {
            method = Box.class.getMethod("add", Integer.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println();

        method = Box.class.getMethod("add", Object.class);

        method.invoke(box, Integer.valueOf(10));

        System.out.println("Box's Value = " + box.get());
    }

    private static class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }
}
