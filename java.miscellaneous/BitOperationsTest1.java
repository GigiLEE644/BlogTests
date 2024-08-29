public class BitOperationsTest1 {
    public static void main(String[] args) {
        int a = 0b00000000000000000000000000001001;

        System.out.println(a);

        int b = 000000000011;

        System.out.println(b);

        int c = 0x00000009;

        System.out.println(c);

        int aa = 0b11111111111111111111111111110111;

        System.out.println(aa);

        int bb = 037777777767;

        System.out.println(bb);

        int cc = 0xFFFFFFF7;

        System.out.println(cc);
    }
}
/*
 * -9 => ?
 * 
 * step 1 -> 9          = 00000000000000000000000000001001
 * step 2 -> step 1 - 1 = 00000000000000000000000000001000
 * step 3 -> ~(step 2)  =  11111111111111111111111111110111
 * 
 * -9 => 11111111111111111111111111110111
 * 
 * 
 * 11111111111111111111111111110111 => ?
 * 
 * step 1 -> first bit is 1, so sign = -
 * step 2 -> ~                       = 00000000000000000000000000001000
 * step 3 -> step 1 + 1              = 00000000000000000000000000001001
 * 
 * 11111111111111111111111111110111 => -9
 * 
 */
