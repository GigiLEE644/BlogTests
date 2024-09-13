public class BitOperationsTest17 {
    public static void main(String[] args) {
        BitSet set = new BitSet(36);

        set.show();

        int num = 33;

        System.out.println("add " + num);

        set.add(num);

        System.out.println("contains " + num + " : " + set.contains(num));

        set.show();

        System.out.println("remove " + num);

        set.remove(num);

        System.out.println("contains " + num + " : " + set.contains(num));

        set.show();
    }

    private static class BitSet {
        private int[] set;
        private int max;

        BitSet(int max) {
            this.max = max;
            int size = this.max / 32 + 1;
            set = new int[size];
        }

        void add(int num) {
            if (num > this.max) {
                return;
            }

            int m = num / 32;

            int n = num % 32;

            this.set[m] |= (1 << n);
        }

        void remove(int num) {
            if (num > this.max) {
                return;
            }

            int m = num / 32;

            int n = num % 32;

            this.set[m] &= ~(1 << n);
        }

        boolean contains(int num) {
            if (num > this.max) {
                return false;
            }

            int m = num / 32;

            int n = num % 32;

            return (this.set[m] & (1 << n)) != 0;
        }

        void show() {
            String bits = "";

            for (int i = 0; i < this.set.length; i++) {
                bits += binary(this.set[i], false);
                bits += '|';
            }

            System.out.println(bits);
        }

        String binary(int num, boolean withoutLeadingZero) {
            String bits = "";

            for (int i = 0; i < 32; i++) {
                int mask = (1 << i);

                if ((num & mask) == 0) {
                    if (!withoutLeadingZero) {
                        bits += '0';
                    } else {
                        if (bits != "") {
                            bits += '0';
                        }
                    }
                } else {
                    bits += '1';
                }
            }

            return bits;
        }
    }
}
