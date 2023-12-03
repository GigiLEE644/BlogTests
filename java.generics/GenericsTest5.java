public class GenericsTest5 {
    public static void main(String[] args) {
        Pair<String, String> name = new Pair<>("name", "tom");

        System.out.println(name);

        Pair<String, Integer> age = new Pair<>("age", 18);

        System.out.println(age);
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