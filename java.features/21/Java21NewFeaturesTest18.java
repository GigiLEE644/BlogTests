import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java21NewFeaturesTest18 {

        public static void main(String[] args) throws IOException, InterruptedException {
                String[] command = { "ls", "-l", "/tmp" };

                Process process = Runtime.getRuntime().exec(command);

                process.waitFor();

                showExecutedResult(process);
        }

        private static void showExecutedResult(Process process) throws IOException {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                        String line = null;

                        while ((line = br.readLine()) != null) {
                                System.out.println(line);
                        }
                }
        }
}