public class BitOperationsTest4 {
    public static void main(String[] args) {
        int a = 0b00000000000000000000000000000010;

        System.out.println(a);

        System.out.println(a << 1);
        System.out.println(0b00000000000000000000000000000100);

        System.out.println(a >> 1);
        System.out.println(0b00000000000000000000000000000001);

        System.out.println(a >>> 1);
        System.out.println(0b00000000000000000000000000000001);

        System.out.println();

        int b = 0b11111111111111111111111111111110;

        System.out.println(b);

        System.out.println(b << 1);
        System.out.println(0b11111111111111111111111111111100);

        System.out.println(b >> 1);
        System.out.println(0b11111111111111111111111111111111);

        System.out.println(b >>> 1);
        System.out.println(0b01111111111111111111111111111111);
    }
}
