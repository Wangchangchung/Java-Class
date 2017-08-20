package com.wcc.niosocket;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by WCC on 2017/3/13.
 *
 * Java netty 这个网络框架
 *
 * 首先介绍一下 Java  的NIO, java nio 在jdk1.4 中引入，主要引入非阻塞io和io多路复用
 * 内部基于 reactor模式
 *
 * nio核心：
 * -buffer
 * -channel
 * -selector
 *
 *
 * buffer：
 * 类似网络编程中的缓冲区，有ByteBuffer字节
 * CharBuffer 字节
 * IntBuffer
 * DoubleBUffer...
 * 常用的有ByteBUffer 和 CharBUffer
 *
 * java nio  buffer是开辟了一块空间，内部有4个标记
 * 分别是position  limint, capicity, mask
 *
 * position是当前读缓冲区位置，limit是数据的结尾，表示最多能读到limit位置，
 * capacity缓冲区的容量，在position 和limit之间还有mask用来标记一个位置，
 * 可以移动 poistion到达mask位置
 * buffer有两个重要的方法： clear  和 flip
 * clear（） 方法没有清空数据，而是将position置为0， limit置为capacity,为再次想buffer中装填数据做准备
 * flip()  方法在装载完数据后，将limit设置为position位置，然后将position设置为0 简单来说就是flip()
 * 为从buffer中取出数据做好准备。
 *
 *
 * channel
 * 类似网络编程中的套接字，Java nio 中称为 Channel(通道) ，服务器和客户端之间通过Channel
 * 开传输数据，
 * Channel 有：
 * FileChannel 文件管道
 * DatagramChannel 数据报管道
 * SocketChannel socket管道
 * ServerSocketChannel 服务端 socket 管道
 * channel  可以直接文件的部分或全部映射为buffer
 * 注意：
 * 程序不能直接访问 channel的数据， channel 必须和 buffer结合起来使用
 * 所有的 channel 都不应该用构造器，重传统的流节点 Inputstream 等来获取channel
 *
 * seletor
 * 事件分发收集器，内部封装epoll， 我们可以往上面注册事件，然后监听 channel 通道上的事件
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

// 实现简单的回射服务器
public class NioScoket {
    // 字符序列和字节序列的编码和解码
    private Charset charset = Charset.forName("utf-8");

    public void run(String ip, int port){

        try {
            //创建服务端套接字
            ServerSocketChannel server = ServerSocketChannel.open();
            //绑定ip和端口
            server.socket().bind(new InetSocketAddress(ip, port));
            //设置非阻塞线程
            server.configureBlocking(false);
            //创建selector事件选择器
            Selector selector = Selector.open();
            // 将自己的监听套接字注册到selector 上，监听 acceot事件
            // SelectionKey代表SelectableChannel和Selector的关系，Selectable是Selector可监听的事件channel.
            server.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0){
                //selector.select() 返回事件
                for (SelectionKey sk: selector.selectedKeys()){
                    //从事件结合中删除正要处理的事件
                    selector.selectedKeys().remove(sk);
                    //判断事件的类型，依次处理
                    if (sk.isAcceptable()){
                        //如果事件为接受连接 accpet事件
                        System.out.println("accpet事件");
                        // 调用accept 接受请求连接
                        SocketChannel client = server.accept();
                        //设置为非阻塞
                        client.configureBlocking(false);
                        //向selector上注册读事件
                        client.register(selector, SelectionKey.OP_READ);
                        //将sk 对应的channel设置为准备接受其他请求
                        sk.interestOps(SelectionKey.OP_ACCEPT);
                    }
                    if (sk.isReadable()){
                        //如果事件为可读事件
                        System.out.println("read事件");
                        SocketChannel client = server.accept();
                        // 定义和缓冲区
                        ByteBuffer buffer =  ByteBuffer.allocate(1024);
                        String  mesg = "";
                        while (client.read(buffer) > 0){
                            buffer.flip();
                            mesg+= charset.decode(buffer);
                        }
                        System.out.println("收到mesg:" +mesg );
                        sk.interestOps(SelectionKey.OP_READ);

                        //回复给发消息的client
                        client.write(charset.encode(mesg));
                        System.out.println("回复：" + mesg);

                    }

                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  void main(String[] args){
        NioScoket scoket = new NioScoket();
        scoket.run("127.0.0.1", 9000);
    }

}
