import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHttpServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Listening for connection on port 8080 ....");
            while (true) {
                try (Socket clientSocket = server.accept()) {
                    InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                    BufferedReader reader = new BufferedReader(isr);
                    // show header info and get content length
                    int len = 0;

                    String line = reader.readLine();
                    while (!line.isEmpty()) {
                        System.out.println(line);

                        if (line.startsWith("Content-Length")) {
                            len = Integer.parseInt(line.split(":")[1].trim());
                        }

                        line = reader.readLine();
                    }

                    // show request body
                    if (len != 0) {
                        char[] body = new char[len];
                        reader.read(body, 0, len);
                        System.out.println(new String(body));
                    }

                    System.out.println();

                    // response
                    Date today = new Date();
                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                    clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}