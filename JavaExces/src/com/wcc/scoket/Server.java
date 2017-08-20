package com.wcc.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by WCC on 2017/3/4.
 */
public class Server {


    public static void main(String atgs[]){
        try {
            // 创建一个ServeSocket监听 8080 端口
            ServerSocket server = new ServerSocket(9000);
            // 等待请求
            Socket socket = server.accept();
            //接受到请求后，使用Socket进行通信，创建BufferedReader 用于读取数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("recevied from client:" + line);
            // 创建PrintWriter,用于发送数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("recevied data" + line);
            pw.flush();
            // 关闭资源
            pw.flush();
            is.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
