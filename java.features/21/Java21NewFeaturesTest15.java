import java.io.File;
import java.io.IOException;

public class Java21NewFeaturesTest15 {

        public static void main(String[] args) throws IOException, InterruptedException {
                ProcessBuilder builder = new ProcessBuilder();

                builder.command("pwd");

                builder.inheritIO();

                Process process = builder.start();

                process.waitFor();

                builder.directory(new File("/tmp"));

                process = builder.start();

                process.waitFor();
        }
}