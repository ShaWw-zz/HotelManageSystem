package Chat.test5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server2 {
    public static  void open(){

        System.out.println("server start...");
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(1008);//25538
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<BufferedWriter> list = new ArrayList<>();


        while(true) {
            //阻塞
            Socket socket = null;
            try {
                socket = ss.accept();
            System.out.println("a client linked");
            //对这个客户端提供收发服务
            //获取字符的缓冲读取流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取字符缓冲写出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            list.add(bw);



            //开启线程提供对这个客户收信息的服务
            new Thread(new ServerRead(br, list, bw)).start();

            //开启线程提供对这个客户发信息的服务
            //  new Thread(new ServerWrite()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
