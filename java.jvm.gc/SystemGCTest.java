public class SystemGCTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new MyClass(i);

            // If System.gc() is guaranted that the actual GC will be triggered
            // Then the result would have been like below

            // 0 is being created
            // 0 is getting garbage collected
            // 1 is being created
            // 1 is getting garbage collected
            // 2 is being created
            // 2 is getting garbage collected
            System.gc();
            // System.runFinalization();
        }
    }

    private static class MyClass {
        private int cid;

        MyClass(int cid) {
            this.cid = cid;
            System.out.printf("%s is being created\n", cid);
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.printf("%s is getting garbage collected\n", cid);
        }
    }
}
