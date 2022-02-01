public class ClassLoadingTest3 {
    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        ClassLoader cl2 = cl.getParent();
        ClassLoader cl3 = cl2.getParent();

        // system class loader
        System.out.println(cl);

        // extension class loader (platform class loader)
        System.out.println(cl2);

        // bootstrap class loader
        System.out.println(cl3);

        ClassLoader scl = ClassLoader.getSystemClassLoader();
        ClassLoader ecl = scl.getParent();
        ClassLoader bcl = ecl.getParent();

        System.out.println(cl == scl);

        System.out.println(cl2 == ecl);

        System.out.println(cl3 == bcl);
    }
}
