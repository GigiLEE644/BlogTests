import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassLoadingTest6 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader cl = new MyClassLoader("/home/yan/github/BlogTests/test");

        Class<?> clazz = cl.loadClass("Person");

        System.out.println(clazz.getClassLoader().getClass().getSimpleName());

        // System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toString());
    }

    private static class MyClassLoader extends ClassLoader {
        private String classFolder;

        public MyClassLoader(String classFolder) {
            this.classFolder = classFolder;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            String separator = File.separator;

            String url;

            if (!this.classFolder.endsWith(separator)) {
                url = this.classFolder + separator + name + ".class";
            } else {
                url = this.classFolder + name + ".class";
            }

            Path path = Paths.get(url);

            byte[] bytes;
            try {
                bytes = Files.readAllBytes(path);

                Class<?> clazz = defineClass(null, bytes, 0, bytes.length);

                return clazz;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
