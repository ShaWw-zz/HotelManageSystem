package Chat.test5;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRead implements Runnable{

    private Socket socket;
    TextArea ta;
    public ClientRead(Socket socket, TextArea ta) {
        this.ta = ta;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    //这个方法执行：不停地读取服务器发来的消息
    public void run() {
            BufferedReader br = null;
            String message = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                //阻塞
                message = br.readLine();
                ta.appendText(message);
                ta.appendText("\t\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
