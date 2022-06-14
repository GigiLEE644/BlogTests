import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Sockets {
    public static void main(String[] args) throws InterruptedException {
        final int port = 8081;

        Runnable server = () -> {
            try (ServerSocket ss = new ServerSocket(port)) {
                Socket accept = ss.accept();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()))) {
                    String line = reader.readLine();
                    System.out.println("server receives greeting message from client : " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        };

        new Thread(server).start();

        Runnable client = () -> {
            try (Socket s = new Socket("localhost", port)) {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
                    writer.write("hello world");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        };

        int seconds = 5;
        System.out.println("wait " + seconds + " seconds before sending greeting message to server !");
        TimeUnit.SECONDS.sleep(seconds);

        new Thread(client).start();
    }
}
