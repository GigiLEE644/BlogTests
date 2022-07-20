import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientServerModeWithDatagram {
    public static void main(String[] args) {
        final InetSocketAddress serverAddress = new InetSocketAddress("localhost", 7001);
        Runnable server = () -> {
            try (DatagramChannel datagramChannel = DatagramChannel.open().bind(serverAddress)) {
                while (true) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    SocketAddress remoteAdd = datagramChannel.receive(buffer);
                    String message = new String(buffer.array(), 0, buffer.position());
                    System.out.println("Client at #" + remoteAdd + "  sent: " + message);
                    buffer.clear();
                }
            } catch (Exception e) { e.printStackTrace(); }
        };

        new Thread(server).start();

        Runnable client = () -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    String line = reader.readLine();
                    try (DatagramChannel datagramChannel = DatagramChannel.open()) {
                        ByteBuffer buffer = ByteBuffer.wrap(line.getBytes());
                        datagramChannel.send(buffer, serverAddress);
                    }
                }
            } catch (Exception e) { e.printStackTrace(); }
        };

        new Thread(client).start();
    }
}
