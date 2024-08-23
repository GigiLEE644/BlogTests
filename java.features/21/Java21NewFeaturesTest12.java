import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest12 {

        public static void main(String[] args) throws IOException {
                List<String> commands = new ArrayList<String>();
                commands.add("ls");
                commands.add("-l");
                commands.add("/tmp");

                ProcessBuilder pb = new ProcessBuilder(commands);

                Process process = pb.start();

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String s = null;
                while ((s = stdInput.readLine()) != null) {
                        System.out.println(s);
                }
        }
}