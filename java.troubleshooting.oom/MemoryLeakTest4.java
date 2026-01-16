public class MemoryLeakTest4 {
    public static void main(String[] args) throws InterruptedException {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.checkOuter();

        // make outer object unused
        outer = null;

        // do explicit gc
        System.gc();
        Thread.sleep(1000);
        System.out.println("A gc is done here.");

        inner.checkOuter();
    }
}

class Outer {
    class Inner {
        // print outer object
        void checkOuter() {
            if (Outer.this != null) {
                System.out.println(Outer.this);
            }
        }
    }
}
/*
 * Output :
 *      Outer@251a69d7
 *      A gc is done here.
 *      Outer@251a69d7
 */