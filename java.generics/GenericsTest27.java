import java.lang.reflect.Array;

public class GenericsTest27 {
    public static void main(String[] args) {
        int size = 5;

        MyArray<Integer> arr = new MyArray<Integer>(Integer.class, size);

        for (int i = 0; i < size; i++) {
            arr.put(i, i);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(arr.get(i));
        }
    }

    private static class MyArray<T> {
        private T[] array;

        public MyArray(Class<T> type, int size) {
            array = (T[]) Array.newInstance(type, size);
        }

        public void put(int index, T item) {
            array[index] = item;
        }

        public T get(int index) {
            return array[index];
        }
    }
}