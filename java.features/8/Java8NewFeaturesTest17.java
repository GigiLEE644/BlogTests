import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8NewFeaturesTest17 {
    public static void main(String[] args) throws IOException {
        String hello = "hello";
        String world = "world";

        // Collection
        List<String> l = Arrays.asList(hello, world);

        Stream<String> ls = l.stream();

        ls.forEach(System.out::println);

        System.out.println();

        // Array
        String[] s = { hello, world };

        Stream<String> as = Arrays.stream(s);

        as.forEach(System.out::println);

        System.out.println();

        // File
        File f = File.createTempFile(hello, world);

        f.deleteOnExit();

        Path p = f.toPath();
        Files.write(p, hello.getBytes(), StandardOpenOption.APPEND);
        Files.write(p, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        Files.write(p, world.getBytes(), StandardOpenOption.APPEND);

        try (Stream<String> fs = Files.lines(p)) {
            fs.forEach(System.out::println);
        }
    }
}
/**
 * Output:
 *      hello
 *      world
 *  
 *      hello
 *      world
 *  
 *      hello
 *      world
 */