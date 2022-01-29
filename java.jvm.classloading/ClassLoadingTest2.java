import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoadingTest2 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        URL[] urls = new URL[1];

        urls[0] = new URL(
                "file:/home/yan/.config/Code/User/workspaceStorage/59afdb4fac8e73818aa12a84de15ed2b/redhat.java/jdt_ws/BlogTests_e0c01ebd/bin/");

        ClassLoader parentClassLoader = null;// ClassLoadingTest2.class.getClassLoader();

        MyClassLoader cl1 = new MyClassLoader("cl1", urls, parentClassLoader);

        String class2load = "ClassLoadingTest2$A";

        Class<?> clazz1 = cl1.loadClass(class2load);

        Class<?> clazz2 = cl1.loadClass(class2load);

        // clazz1 and clazz2 are both loaded by the same class loader cl1
        // so they are the same
        System.out.println(clazz1 == clazz2 && clazz1.equals(clazz2));

        MyClassLoader cl2 = new MyClassLoader("cl2", urls, parentClassLoader);

        clazz2 = cl2.loadClass(class2load);

        // clazz1 is loaded by class loader cl1
        // clazz2 is loaded by class loader cl2
        // since the class loader is not the same
        // even if the loaded class name is the same
        // but the final loaded class are not the same
        System.out.println(clazz1 == clazz2 && clazz1.equals(clazz2));

        cl1.close();
        cl2.close();
    }

    private static class MyClassLoader extends URLClassLoader {
        public MyClassLoader(String name, URL[] urls, ClassLoader parent) {
            super(name, urls, parent);
        }
    }

    private static class A {
    }
}
