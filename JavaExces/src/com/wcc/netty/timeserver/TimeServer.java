package com.wcc.netty.timeserver;

import com.wcc.netty.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by charse on 17-4-9.
 */
public class TimeServer {

    private int port;

    public TimeServer(int port){
        this.port = port;
    }

    public void run(){
        EventLoopGroup bossGroup =  new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new TimeServerHandler());
            }
        })
        .option(ChannelOption.SO_BACKLOG, 128)
        .childOption(ChannelOption.SO_KEEPALIVE, true);


        // 绑定端口，开始接收进来的连接
        try {
            ChannelFuture future = bootstrap.bind(port).sync();

            //等待服务器 Socket 关闭
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static  void  main(String[] args){
        int port;
        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }else {
            port = 8080;
        }
        new TimeServer(port).run();
    }
}
