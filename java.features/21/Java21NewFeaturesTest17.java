import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest17 {

        public static void main(String[] args) throws IOException, InterruptedException {
                // ls | wc -l
                ProcessBuilder ls = new ProcessBuilder("ls");
                ProcessBuilder wc = new ProcessBuilder("wc", "-l");

                List<ProcessBuilder> builders = new ArrayList<ProcessBuilder>() {
                        {
                                add(ls);
                                add(wc);
                        }
                };

                List<Process> processes = ProcessBuilder.startPipeline(builders);

                Process process = processes.getLast();

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