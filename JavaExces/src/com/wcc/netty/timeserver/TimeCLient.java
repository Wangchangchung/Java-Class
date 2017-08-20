package com.wcc.netty.timeserver;

import com.wcc.netty.TimeServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by charse on 17-4-9.
 */
public class TimeCLient {

    public static  void main(String[] args){

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        EventLoopGroup  workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();   //  (1) bootstrap 的中文意识时引导程序
        bootstrap.group(workerGroup);             // (2)
        bootstrap.channel(NioSocketChannel.class);      //(3)
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);  // (4)

        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new TimeServerHandler());
            }
        });

        // 启动客户端
        try {
            ChannelFuture  future = bootstrap.connect(host,port).sync();  // (5)
            // 等待连接关闭
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * 1、BootStrap 和 ServerBootstrap 类似，不过他是非服务器端的Channel 而言。
     * 比如客户端或者无线连接传输模式的Channel
     *
     * 2、如果你指定了一个EventLoopGroup,
     */
}
