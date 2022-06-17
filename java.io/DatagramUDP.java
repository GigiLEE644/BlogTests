import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class DatagramUDP {
    public static void main(String[] args) throws InterruptedException {
        final int port = 3000;
        final String host = "localhost";

        receive(port, host);

        TimeUnit.SECONDS.sleep(1);
        
        send(port, host);
    }

    private static void receive(final int port, final String host) {
        Runnable receiver = () -> {
            try (DatagramSocket ds = new DatagramSocket(port, InetAddress.getByName(host))) {
                byte[] buffer = new byte[1024];

                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

                ds.receive(dp);

                System.out.println("Data received : " + new String(dp.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(receiver).start();
    }

    private static void send(final int port, final String host) {
        Runnable sender = () -> {
            try (DatagramSocket ds = new DatagramSocket()) {
                String greeting = "hello world";

                byte[] bytes = greeting.getBytes();
                int len = bytes.length;
                InetAddress address = InetAddress.getByName(host);

                ds.send(new DatagramPacket(bytes, len, address, port));

                System.out.println("Data (" + greeting + ") sent ...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(sender).start();
    }
}
