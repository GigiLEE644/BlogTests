import java.util.Arrays;

public class LocalVariablesTest2 {
    public static void main(String[] args) {
    }

    private static class Cooker {
        private String name;

        public Cooker(String name) {
            this.name = name;
        }

        public void cook(String[] dishes) {
            int num = dishes.length;
            System.out.println(this.name + " cooks " + num + " dishes : "
                    + Arrays.toString(dishes));
        }
    }
}
