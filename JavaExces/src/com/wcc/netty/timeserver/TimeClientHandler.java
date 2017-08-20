package com.wcc.netty.timeserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by charse on 17-4-9.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    /*
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf m = (ByteBuf)msg;  // (1)

        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
    */

    /**
     *  1、 在TCP/IP 中，Netty 会把读取到的数据放入到ByteBuf 中的数据结构中
     * 问题：
     * 在基于流的传输里比如TCP/IP，接收到的数据会先被存储到一个socket接收缓冲里。
     * 不幸的是，基于流的传输并不是一个数据包队列，而是一个字节队列。
     * 即使你发送了2个独立的数据包，操作系统也不会作为2个消息处理而仅仅是作为一连串的字节而言。
     * 因此这是不能保证你远程写入的数据就会准确地读取。举个例子，
     * 让我们假设操作系统的TCP/TP协议栈已经接收了3个数据包：
     *
     * 因此，一个接收方不管他是客户端还是服务端，
     * 都应该把接收到的数据整理成一个或者多个更有意思并且能够让程序的业务逻辑更好理解的数据。
     * 在上面的例子中，接收到的数据应该被构造成下面的格式：
     */

    //---------------------------解决方案一----------------------------------------------

    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        buf = ctx.alloc().buffer(4);  //  (1)
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        buf.writeBytes(m);
        m.release();
        if (buf.readableBytes() >= 4){
            long currentTimeMillis = (buf.readInt()-2208988800L)*1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        buf.release();  // (1)
        buf = null;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /*
     1、ChannelHandler 有2个生命周期的监听方法: handlerAdded()和handlerRemoved()。你可以完成任意初始化任务只要他不会被阻塞很长的时间。
     2、首先，所有接收的数据都应该被累积在buf变量里。
     3、然后、处理器必须检查buf 变量是否有足够的数据，在这个例子中是4字节， 然后处理实际的业务逻辑
     否则，Netty会重复调用channelRead()当有更多数据到达直到4个字节的数据被积累。


      */

}
