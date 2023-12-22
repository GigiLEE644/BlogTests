public class GenericsTest21 {
    public static void main(String[] args) {
        StringContainer sc = new StringContainer();

        sc.setValue("hello");

        sc.getValue();
    }
}

class Container<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class StringContainer extends Container<String> {
    @Override
    public String getValue() {
        System.out.println("getValue : ");
        String value = super.getValue();
        System.out.println(value);
        return value;
    }

    @Override
    public void setValue(String value) {
        System.out.println("setValue : ");
        System.out.println(value);
        super.setValue(value);
    }
}