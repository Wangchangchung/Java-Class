package com.wcc.niosocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by WCC on 2017/3/4.
 *从Java 1.4 开始 Java新增了i模式（nio new IO） nio在底层采用了新的处理方式
 * 极大的提高了IO的效率，
 * Nio 提供了相应的工具：ServerSocketChannel 和 SocketChannel
 * 分别来对应 ServerSocket 和Socket
 */
public class NIOServer {
    public static  void main(String args[]){
        //创建ServerSockeChannel，监听8080 端口
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(9000));
            // 设置为非阻塞的模式
            ssc.configureBlocking(false);
            // 为ssc 注册选择器
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            //创建处理器
            Handler handler = new Handler(1024);
            while (true){
                if (selector.select(3000) == 0 ){
                    System.out.println("等待超时了。。。。");
                    continue;
                }
                System.out.println("处理请求。。。。");
                // 获取待处理的SelectionKey
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    try {
                        if (key.isAcceptable()){
                            handler.handleAccept(key);
                        }
                        if (key.isReadable()){
                            handler.handleRead(key);
                        }
                    }catch (IOException ex){
                        keyIterator.remove();
                        continue;
                    }
                    //处理完后将key重迭代器中删除所使用的key
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler{
        private int buffersize = 1024;
        private String localCharset = "UTF-8";
        public Handler(){}
        public Handler(int buffersize){
            this(buffersize, null);
        }
        public Handler(String localCharset){
            this(-1, localCharset);
        }
        public Handler(int buffersize, String localCharset){
            if (buffersize > 0){
                this.buffersize  = buffersize;
            }
            if (localCharset != null){
                this.localCharset = localCharset;
            }
        }
        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel sc =((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(),
                    SelectionKey.OP_ACCEPT, ByteBuffer.allocate(buffersize));
        }
        public void handleRead(SelectionKey key) throws IOException {
            //获取channel
            SocketChannel sc= (SocketChannel) key.channel();
            // 获取buffer 并重置
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            //没有读到内容则关闭
            if(sc.read(buffer) == -1){
                sc.close();
            }else {
                //将buffer 转化为读状态
                buffer.flip();
                // 将buffer 中接收的值按照 localCharset 格式编码后保存到receiveSting中
                String receiveString = Charset.forName(localCharset).
                        newDecoder().decode(buffer).toString();
                System.out.println("recevied from client: " + receiveString);

                // 返回数据给客户端
                String sendString = "recevied data : " + receiveString;
                buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                sc.write(buffer);
                // 关闭socket
                sc.close();
            }
        }
    }

}


