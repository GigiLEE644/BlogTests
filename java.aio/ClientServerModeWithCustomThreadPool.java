import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientServerModeWithCustomThreadPool {
    public static void main(String[] args) throws InterruptedException {
        final InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8383);

        Runnable server = () -> {
            try {
                ExecutorService threadPool = Executors.newFixedThreadPool(2, r -> {
                    Timestamp ts = Timestamp.from(Instant.now());
                    Thread t = new Thread(r);
                    t.setName("MyThread-" + ts.getTime());
                    return t;
                });
                AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(threadPool);
                try (AsynchronousServerSocketChannel assChannel = AsynchronousServerSocketChannel.open(group)
                        .bind(serverAddress)) {
                    assChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
                        @Override
                        public void completed(AsynchronousSocketChannel asChannel, Void attachment) {
                            assChannel.accept(null, this);

                            ByteBuffer buffer = ByteBuffer.allocate(1024);

                            StringBuilder sb = new StringBuilder();

                            try {
                                while (asChannel.read(buffer).get() > 0) {
                                    sb.append(new String(buffer.array(), 0, buffer.position()));
                                    buffer.clear();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            System.out.println(
                                    "Server (" + Thread.currentThread().getName() + ") receives : " + sb.toString());
                            System.out.println();
                        }

                        @Override
                        public void failed(Throwable exc, Void attachment) {

                        }
                    });

                    Thread.currentThread().join();
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

                    try (AsynchronousSocketChannel asChannel = AsynchronousSocketChannel.open()) {
                        asChannel.connect(serverAddress).get();

                        System.out.print("Client (" + Thread.currentThread().getName() + ") sends : " + line);
                        System.out.println();

                        ByteBuffer buffer = ByteBuffer.wrap(line.getBytes());
                        asChannel.write(buffer);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(client).start();
    }
}
