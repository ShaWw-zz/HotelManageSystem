package Chat.test5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerText implements Runnable{
    public static synchronized   void  server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8234);
        System.out.println("服务器启动！");

        ArrayList<BufferedWriter> list = new ArrayList<>();

        while (true){

            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功！");
            // 读取数据流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 写出数据流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            list.add(bufferedWriter);
            // 开启线程进行收发

            new Thread(new ServerRead(bufferedReader,list,bufferedWriter)).start();
    }
}

    @Override
    public void run() {
        try {
            server();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
