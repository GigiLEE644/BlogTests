public class ClassLoadingTest {
    /**
     * -XX:+TraceClassLoading
     * -Xlog:class+load=info for JDK 17+
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // actif
        Class<?> clazz = Class.forName("ClassLoadingTest$A");

        // actif
        ClassLoader classLoader = ClassLoadingTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("ClassLoadingTest$A");

        // passif
        A a = new A();
    }

    private static class A {
    }
}
