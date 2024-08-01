import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java17NewFeaturesTest15 {

        public static void main(String[] args) {
                List<ShoppingCart.Item> egg_milk_cheese = new ArrayList<>() {
                        {
                                add(new ShoppingCart.Item("egg", 6));
                                add(new ShoppingCart.Item("milk", 2));
                                add(new ShoppingCart.Item("cheese", 4));
                        }
                };

                List<ShoppingCart.Item> rice_bread_noodle = new ArrayList<>() {
                        {
                                add(new ShoppingCart.Item("rice", 1));
                                add(new ShoppingCart.Item("bread", 2));
                                add(new ShoppingCart.Item("noodle", 1));
                        }
                };

                List<ShoppingCart> carts = new ArrayList<>() {
                        {
                                add(new ShoppingCart(egg_milk_cheese));
                                add(new ShoppingCart(rice_bread_noodle));
                        }
                };

                record Payment(ShoppingCart cart) {
                        int total() {
                                int total = 0;

                                for (ShoppingCart.Item item : cart.items) {
                                        total += item.price;
                                }

                                return total;
                        }
                }
                ;

                carts.stream().map(cart -> new Payment(cart)).sorted((p1, p2) -> p1.total() - p2.total())
                                .map(p -> p.cart.items).forEach(items -> {
                                        List<String> itemsName = items.stream().map(item -> item.name)
                                                        .collect(Collectors.toList());
                                        System.out.println(itemsName);
                                });
        }

        private static class ShoppingCart {
                List<Item> items;

                public ShoppingCart(List<Item> items) {
                        this.items = items;
                }

                private static class Item {
                        String name;
                        int price;

                        public Item(String name, int price) {
                                this.name = name;
                                this.price = price;
                        }
                }
        }
}