import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Java21NewFeaturesTest16 {

        public static void main(String[] args) throws IOException, InterruptedException {
                ProcessBuilder builder = new ProcessBuilder();

                builder.command("ls", "-l", "/tmp");

                Path temp = Files.createTempFile("hello", "world");

                builder.redirectOutput(temp.toFile());

                Process process = builder.start();

                process.waitFor();

                try {
                        String output = new String(Files.readAllBytes(temp));

                        System.out.println(output);
                } finally {
                        Files.deleteIfExists(temp);
                }
        }
}