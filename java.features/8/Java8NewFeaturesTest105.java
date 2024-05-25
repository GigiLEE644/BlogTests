import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Java8NewFeaturesTest105 {

    public static void main(String[] args) {
        Product p1 = new Product(1, "candy");
        Product p2 = new Product(2, "milk");

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        ShoppingCart<Product> cart = new ShoppingCart<>(products);

        Iterator<Product> it = cart.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        for (Product p : cart) {
            System.out.println(p);
        }

        System.out.println();

        cart.forEach(System.out::println);

        System.out.println();

        it = cart.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            it.remove();
        }

        System.out.println();
        System.out.println(products.size());
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

        public ShoppingCart(List<E> elements) {
            this.elements = elements;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < elements.size();
                }

                @Override
                public E next() {
                    E next = elements.get(index++);
                    return next;
                }

                @Override
                public void remove() {
                    elements.remove(--index);
                }
            };
        }
    }
}