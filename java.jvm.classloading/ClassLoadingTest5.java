public class ClassLoadingTest5 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoadingTest5.class.getClassLoader();

        cl.loadClass("ClassLoadingTest5$A");

        Class.forName("ClassLoadingTest5$B");

        // when using a classloader
        // the second parameter allows to do the initialization explicitly
        // if it is false, then there is no initialization
        Class.forName("ClassLoadingTest5$C", false, cl);

        // if it is true, then there is initialization
        Class.forName("ClassLoadingTest5$D", true, cl);
    }

    private static class A {
        static {
            System.out.println("A is initialized");
        }
    }

    private static class B {
        static {
            System.out.println("B is initialized");
        }
    }

    private static class C {
        static {
            System.out.println("C is initialized");
        }
    }

    private static class D {
        static {
            System.out.println("D is initialized");
        }
    }
}
