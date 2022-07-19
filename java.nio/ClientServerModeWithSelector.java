import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientServerModeWithSelector {
    public static void main(String[] args) {
        final String host = "localhost";
        final int port = 8888;

        Runnable server = () -> {
            try (Selector selector = Selector.open()) {
                ServerSocketChannel ssChannel = ServerSocketChannel.open();
                ssChannel.configureBlocking(false);
                ssChannel.register(selector, SelectionKey.OP_ACCEPT);
                ssChannel.socket().bind(new InetSocketAddress(host, port));

                while (true) {
                    selector.select();
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();

                    while (it.hasNext()) {
                        SelectionKey key = it.next();

                        if (key.isAcceptable()) {
                            SocketChannel sChannel = ((ServerSocketChannel) key.channel()).accept();
                            sChannel.configureBlocking(false);
                            sChannel.register(selector, SelectionKey.OP_READ);
                        } else if (key.isReadable()) {
                            SocketChannel sChannel = (SocketChannel) key.channel();
                            System.out.println(
                                    "Server (" + Thread.currentThread().getName() + ") receives : "
                                            + readDataFromSocketChannel(sChannel));
                            System.out.println();
                            sChannel.close();
                        }

                        it.remove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(server).start();

        Runnable client = () -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    String line = reader.readLine();
                    sendDataThroughSocket(host, port, line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(client).start();

    }

    private static void sendDataThroughSocket(String host, int port, String data)
            throws UnknownHostException, IOException {
        try (Socket socket = new Socket(host, port)) {
            OutputStream out = socket.getOutputStream();
            System.out.print("Client (" + Thread.currentThread().getName() + ") sends : " + data);
            System.out.println();
            out.write(data.getBytes());
        }
    }

    private static String readDataFromSocketChannel(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder sb = new StringBuilder();

        while (channel.read(buffer) > 0) {
            sb.append(new String(buffer.array(), 0, buffer.position()));
            buffer.clear();
        }

        return sb.toString();
    }
}
