public class Java11NewFeaturesTest12 {

        static final int MEGABYTE_IN_BYTES = 1024 * 1024;
        static final int ITERATION_COUNT = 1024 * 2;

        public static void main(String[] args) {
                System.out.println("Start");

                for (int i = 0; i < ITERATION_COUNT; i++) {
                        byte[] array = new byte[MEGABYTE_IN_BYTES];
                }

                System.out.println("End");
        }
}

// java -Xms1024m -Xmx1024m

/*
Output:
        Start
        End
 */

// java -Xms1024m -Xmx1024m -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC

/*
Output:
        Start
        Terminating due to java.lang.OutOfMemoryError: Java heap space
 */