public class Java21NewFeaturesTest7 {

        public static void main(String[] args) {
                Thread t = Thread.startVirtualThread(() -> {
                        System.out.println("Running task in a virtual thread : " + Thread.currentThread());
                });

                try {
                        t.join();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }
}