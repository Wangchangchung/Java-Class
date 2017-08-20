package com.wcc.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by WCC on 2017/3/4.
 */
public class Client {
    public static void main(String args[]) {
        String msg = "Client Data";
        try {
            // 创建一个socket，跟本机 9000 端口连接
            Socket socket = new Socket("127.0.0.1", 9000);
            // 使用Socket创建PrintWriter 和BufferReader进行读写操作
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 发送数据
            pw.println(msg);
            pw.flush();
            //接受数据
            String line = is.readLine();
            System.out.println("recevied from server:" + line);

            //关闭资源
            pw.close();;
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

