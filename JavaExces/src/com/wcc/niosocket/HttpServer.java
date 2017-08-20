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
import java.util.Iterator;

/**
 * Created by WCC on 2017/3/4.
 *
 * 使用 NIOSocket 实现 HTTP协议
 *
 */
public class HttpServer {

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
                    //启动新线程处理 SelectionKey
                    new Thread(new Handler(key)).run();
                    // 处理完后， 从待处理的selectionKey 迭代器中移除当前所使用的的key
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler implements  Runnable{
        private int buffersize = 1024;
        private String localCharset = "UTF-8";
        private  SelectionKey selectionKey;

        public  Handler(){}
        public Handler(SelectionKey key){
            this.selectionKey = key;
        }
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


        public void handleAccept() throws IOException {
            SocketChannel sc =((ServerSocketChannel) selectionKey.channel()).accept();
            sc.configureBlocking(false);
            sc.register(selectionKey.selector(),
                    SelectionKey.OP_READ, ByteBuffer.allocate(buffersize));
        }
        public void handleRead() throws IOException {
            //获取channel
            SocketChannel sc= (SocketChannel) selectionKey.channel();
            // 获取buffer 并重置
            ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
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
                //System.out.println("recevied from client: " + receiveString);

               //控制台打印请求报文
                String[] requestMesssage = receiveString.split("\r\n");
                for (String s : requestMesssage){
                    System.out.println(s);
                    //遇到空行说明报文头已经打印完了
                    if(s.isEmpty()) {
                        break;
                    }
                }
                String[] firstLine = requestMesssage[0].split(" ");
                System.out.println();
                System.out.println("Method:\t" + firstLine[0] );
                System.out.println("url:\t" + firstLine[1]);
                System.out.println("HTTP Version:\t" + firstLine[2]);
                System.out.println();

                // 返回客户端
                StringBuffer sendString = new StringBuffer();
                // 响应报文首行 200 表示处理成功
                sendString.append("HTTP/1.1 200 OK\r\n");

                sendString.append("Content-Type:text/html;charset=" + localCharset + "\r\n");
                sendString.append("\r\n");

                sendString.append("<html><head><title>显示报文</title></head><body>");

                sendString.append("接收到的请求报文时：" + "<br/>");
                for (String s : requestMesssage){
                    sendString.append(s + "<br/>");
                }

                sendString.append("</body></html>");

                buffer = ByteBuffer.wrap(sendString.toString().getBytes(localCharset));
                sc.write(buffer);
                sc.close();
            }
        }
        @Override
        public void run(){
            try {
                if (selectionKey.isAcceptable()){
                    handleAccept();
                }
                if (selectionKey.isReadable()){
                    handleRead();
                }
            }catch (IOException ec){
                ec.printStackTrace();
            }
        }
    }
}
