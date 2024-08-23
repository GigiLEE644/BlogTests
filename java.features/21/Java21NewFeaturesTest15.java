import java.util.Map;

public class Java21NewFeaturesTest15 {

        public static void main(String[] args) {
                ProcessBuilder pb = new ProcessBuilder();

                Map<String, String> envMap = pb.environment();

                for (Map.Entry<String, String> entry : envMap.entrySet()) {
                        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                }
        }
}