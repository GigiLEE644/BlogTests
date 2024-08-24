import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest12 {

        public static void main(String[] args) throws IOException, InterruptedException {
                List<String> command = new ArrayList<String>() {
                        {
                                add("ls");
                                add("-l");
                                add("/tmp");
                        }
                };

                ProcessBuilder builder = new ProcessBuilder(command);

                System.out.println("command to be executed : " + builder.command());

                Process process = builder.start();

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