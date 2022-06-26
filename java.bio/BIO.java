import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class BIO {
    public static void main(String[] args) throws InterruptedException {
        final int port = 3000;

        Runnable server = () -> {
            try (ServerSocket ss = new ServerSocket(port)) {
                while (true) {
                    Socket accept = ss.accept();

                    Runnable handler = () -> {
                        handleRequest(accept);
                    };

                    new Thread(handler).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(server).start();

        TimeUnit.SECONDS.sleep(3);

        Runnable clientA = () -> {
            sendRequest(port, "A", "hello world");
        };

        new Thread(clientA).start();

        Runnable clientB = () -> {
            sendRequest(port, "B", "world hello");
        };

        new Thread(clientB).start();
    }

    private static void handleRequest(Socket accept) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()))) {
            StringWriter writer = new StringWriter();

            String line;

            while ((line = br.readLine()) != null) {
                writer.write(line);
            }

            String request = writer.toString();

            System.out.println(
                    "request '" + request + "' has been handled by server's thread " + Thread.currentThread().getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(final int port, String client, String request) {
        try (Socket s = new Socket("localhost", port)) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
                bw.write(request);
                System.out.println(
                        "request '" + request + "' has been sent to server by client " + client + "'s thread "
                                + Thread.currentThread().getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
