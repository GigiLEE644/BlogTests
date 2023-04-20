package com.example;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.ReplayingDecoder;

public class ClientServerModeWithNetty {
    public static void main(String[] args) {
        final int port = 8080;
        final String host = "localhost";

        Runnable server = () -> {
            final String tName = Thread.currentThread().getName();
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup);
                b.channel(NioServerSocketChannel.class);
                b.childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                            throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MessageEncoder());
                        p.addLast(new MessageDecoder());
                        p.addLast(new ServerHandler(tName));
                    }
                });

                ChannelFuture f = b.bind(port).sync();
                f.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }
        };

        new Thread(server).start();

        Runnable client = () -> {
            final String clientName = Thread.currentThread().getName();
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            try {
                Bootstrap b = new Bootstrap();
                b.group(workerGroup);
                b.channel(NioSocketChannel.class);
                b.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                            throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MessageEncoder());
                        p.addLast(new MessageDecoder());
                        p.addLast(new ClientHandler(clientName));
                    }
                });

                ChannelFuture f = b.connect(host, port).sync();

                Channel channel = f.sync().channel();
                channel.writeAndFlush(new Message(1, "hello server"));
                channel.flush();

                f.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                workerGroup.shutdownGracefully();
            }
        };

        new Thread(client).start();
    }

    private static class Message {
        private int id;
        private String content;

        public Message() {

        }

        public Message(int id, String content) {
            this.id = id;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Message [id = " + id + ", content = " + content + "]";
        }
    }

    private static class MessageDecoder extends ReplayingDecoder<Message> {
        @Override
        protected void decode(ChannelHandlerContext ctx,
                ByteBuf in, List<Object> out) throws Exception {
            Message message = new Message();
            message.setId(in.readInt());
            int len = in.readInt();
            message.setContent(in.readCharSequence(len, Charset.forName("UTF-8")).toString());
            out.add(message);
        }
    }

    private static class MessageEncoder extends MessageToByteEncoder<Message> {
        @Override
        protected void encode(ChannelHandlerContext ctx,
                Message message, ByteBuf out) throws Exception {
            out.writeInt(message.getId());
            out.writeInt(message.getContent().length());
            out.writeCharSequence(message.getContent(), Charset.forName("UTF-8"));
        }
    }

    private static class ClientHandler extends ChannelInboundHandlerAdapter {
        private String clientName;

        ClientHandler(String clientName) {
            this.clientName = clientName;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object message)
                throws Exception {
            String tName = Thread.currentThread().getName();
            System.out.println(tName + " : Client (" + this.clientName + ") receives response = " + (Message) message);
        }
    }

    private static class ServerHandler extends ChannelInboundHandlerAdapter {
        private String serverName;

        ServerHandler(String serverName) {
            this.serverName = serverName;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object message)
                throws Exception {
            String tName = Thread.currentThread().getName();
            System.out.println(tName + " : Server (" + this.serverName + ") receives request = " + (Message) message);
            ctx.channel().writeAndFlush(new Message(2, "hello client"));
        }
    }
}