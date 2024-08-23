import java.io.IOException;

public class Java21NewFeaturesTest13 {

        public static void main(String[] args) throws IOException, InterruptedException {
                ProcessBuilder pb = new ProcessBuilder(
                                "echo", "Hello GeeksforGeeks\n"
                                                + "This is ProcessBuilder Example");
                pb.inheritIO();
                Process process = pb.start();
                process.waitFor();
        }
}