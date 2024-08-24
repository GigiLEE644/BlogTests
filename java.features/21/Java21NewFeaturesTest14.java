import java.io.IOException;
import java.util.Map;

public class Java21NewFeaturesTest14 {

        public static void main(String[] args) throws IOException, InterruptedException {
                ProcessBuilder builder = new ProcessBuilder();

                Map<String, String> environment = builder.environment();

                environment.put("greeting", "hello world");

                builder.command("/bin/bash", "-c", "echo $greeting");

                builder.inheritIO();

                Process process = builder.start();

                process.waitFor();
        }
}