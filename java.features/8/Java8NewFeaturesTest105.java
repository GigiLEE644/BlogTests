import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Java8NewFeaturesTest105 {

    public static void main(String[] args) {
        Product p1 = new Product(1, "candy");
        Product p2 = new Product(2, "milk");

        List<Product> products = Arrays.asList(p1, p2);

        ShoppingCart<Product> cart = new ShoppingCart<>(products);

        for (Product p : cart) {
            System.out.println(p);
        }
    }

    private static class Product {
        private int id;
        private String name;

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product [id=" + id + ", name=" + name + "]";
        }
    }

    private static class ShoppingCart<E> implements Iterable<E> {
        private List<E> elements;
        private int index;

        public ShoppingCart(List<E> elements) {
            this.elements = elements;
            this.index = 0;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                @Override
                public boolean hasNext() {
                    return index < elements.size();
                }

                @Override
                public E next() {
                    E next = elements.get(index++);
                    return next;
                }
            };
        }
    }
}