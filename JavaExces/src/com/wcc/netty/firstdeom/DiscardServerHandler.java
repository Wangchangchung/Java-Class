package com.wcc.netty.firstdeom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by charse on 17-4-9.
 */

/**
 * 处理服务器端 Channel
 */
public class DiscardServerHandler  extends ChannelInboundHandlerAdapter {

    @Override
    public void  channelRead(ChannelHandlerContext ctx, Object msg){
        //默默的丢弃接收到的数据
        ByteBuf in  = (ByteBuf)msg;
        ctx.write(msg);
        ctx.flush();

        /*
        try{

            while (in.isReadable()){
                System.out.println((char)in.readByte());
                System.out.flush();
            }

        }finally {
            ReferenceCountUtil.release(msg);
        }
        */
        /*
            1、ChannelHandlerContext 对象提供了许多操作，使你能够触发
            各种各样的I/O事件和操作，这里我们调用 write(Object) 方法
            来逐字的把接收的消息写入，请注意不同于  之前我们在服务器端输出
            的例子，我们并没有释放接收到的消息，这是因为当写入的时候 Netty
            已近帮我们释放了

            2、ctx.write(Objetc)方法是因为当写入到通道上，他被缓冲在了内部，你需要调用ctx.flush()
            方法来把缓存中的数据强行输出，或者可以 使用更加简介的方法 cxt.writeAndFlush(msg) 以达到同样的目的

         */

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

}

