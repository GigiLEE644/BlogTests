import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        while (true) {
            try {
                process();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void process() throws InterruptedException {
        sleep(1);

        Map<Integer, String> greetings = new HashMap<>();
        greetings.put(1, "hello");
        greetings.put(2, "world");

        print("hello", greetings, random(1, 9));
    }

    private static void print(String greeting, Map<Integer, String> greetings, int i) {
        int index = greetings.get(i).indexOf(greeting);

        if (index == -1) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }

    private static void sleep(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    private static int random(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

    }
}
