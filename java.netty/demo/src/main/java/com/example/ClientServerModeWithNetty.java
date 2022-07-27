package com.example;

import java.nio.charset.Charset;
import java.util.List;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
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
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch)
                                    throws Exception {
                                ch.pipeline().addLast(new RequestDecoder(),
                                        new ResponseDataEncoder(),
                                        new ProcessingHandler());
                            }
                        }).option(ChannelOption.SO_BACKLOG, 128)
                        .childOption(ChannelOption.SO_KEEPALIVE, true);

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
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            try {
                Bootstrap b = new Bootstrap();
                b.group(workerGroup);
                b.channel(NioSocketChannel.class);
                b.option(ChannelOption.SO_KEEPALIVE, true);
                b.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                            throws Exception {
                        ch.pipeline().addLast(new RequestDataEncoder(),
                                new ResponseDataDecoder(), new ClientHandler());
                    }
                });

                ChannelFuture f = b.connect(host, port).sync();

                f.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                workerGroup.shutdownGracefully();
            }
        };

        new Thread(client).start();
    }

    private static class RequestData {
        private int intValue;
        private String stringValue;

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public String getStringValue() {
            return stringValue;
        }

        public void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return "RequestData [intValue=" + intValue + ", stringValue=" + stringValue + "]";
        }
    }

    private static class RequestDecoder extends ReplayingDecoder<RequestData> {
        private final Charset charset = Charset.forName("UTF-8");

        @Override
        protected void decode(ChannelHandlerContext ctx,
                ByteBuf in, List<Object> out) throws Exception {
            RequestData data = new RequestData();
            data.setIntValue(in.readInt());
            int strLen = in.readInt();
            data.setStringValue(
                    in.readCharSequence(strLen, charset).toString());
            out.add(data);
        }
    }

    private static class RequestDataEncoder extends MessageToByteEncoder<RequestData> {
        private final Charset charset = Charset.forName("UTF-8");

        @Override
        protected void encode(ChannelHandlerContext ctx,
                RequestData msg, ByteBuf out) throws Exception {

            out.writeInt(msg.getIntValue());
            out.writeInt(msg.getStringValue().length());
            out.writeCharSequence(msg.getStringValue(), charset);
        }
    }

    private static class ResponseData {
        private int intValue;

        @Override
        public String toString() {
            return "ResponseData [intValue=" + intValue + "]";
        }

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

    }

    private static class ResponseDataEncoder extends MessageToByteEncoder<ResponseData> {
        @Override
        protected void encode(ChannelHandlerContext ctx,
                ResponseData msg, ByteBuf out) throws Exception {
            out.writeInt(msg.getIntValue());
        }
    }

    private static class ResponseDataDecoder extends ReplayingDecoder<ResponseData> {
        @Override
        protected void decode(ChannelHandlerContext ctx,
                ByteBuf in, List<Object> out) throws Exception {

            ResponseData data = new ResponseData();
            data.setIntValue(in.readInt());
            out.add(data);
        }
    }

    private static class ClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx)
                throws Exception {
            RequestData msg = new RequestData();
            msg.setIntValue(123);
            msg.setStringValue(
                    "all work and no play makes jack a dull boy");
            ChannelFuture future = ctx.writeAndFlush(msg);
            future.get();
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg)
                throws Exception {
            System.out.println((ResponseData) msg);
            ctx.close();
        }
    }

    private static class ProcessingHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg)
                throws Exception {
            RequestData requestData = (RequestData) msg;
            ResponseData responseData = new ResponseData();
            responseData.setIntValue(requestData.getIntValue() * 2);
            ChannelFuture future = ctx.writeAndFlush(responseData);
            future.addListener(ChannelFutureListener.CLOSE);
            System.out.println(requestData);
        }
    }
}