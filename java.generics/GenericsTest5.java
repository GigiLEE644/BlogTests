public class GenericsTest5 {
    public static void main(String[] args) {
        Pair<String, Integer> tom = new Pair<>("tom", 18);
        Pair<String, Integer> jerry = new Pair<>("jerry", 16);

        System.out.println(tom);
        System.out.println(jerry);
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair [key=" + key + ", value=" + value + "]";
        }
    }
}