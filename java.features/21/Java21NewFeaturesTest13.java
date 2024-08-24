import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest13 {

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

                builder.inheritIO();

                Process process = builder.start();

                process.waitFor();
        }
}