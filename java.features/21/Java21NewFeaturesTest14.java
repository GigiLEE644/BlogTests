import java.util.ArrayList;
import java.util.List;

public class Java21NewFeaturesTest14 {

        public static void main(String[] args) {
                List<String> list = new ArrayList<String>();
                list.add("notepad.exe");
                list.add("xyz.txt");

                ProcessBuilder build = new ProcessBuilder(list);

                System.out.println("command: " + build.command());
        }
}