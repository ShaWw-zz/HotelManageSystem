package Chat.test5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServerRead implements Runnable {

    private BufferedReader br;
    private ArrayList<BufferedWriter> list;
    private BufferedWriter bw;

    public ServerRead(BufferedReader br,ArrayList<BufferedWriter> list, BufferedWriter bw) {
        this.br = br;
        this.list = list;
        this.bw = bw;
    }

    //任务：读取客户端发送过来信息
    public void run() {
        String name = null;
        try {

            name = br.readLine();

            for(BufferedWriter bw2 : list) {
                if(bw2 == bw) {
                    continue;
                }
                bw2.write(name + "来了");
                bw2.newLine();
                bw2.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        while(true) {
            try {
                String message = br.readLine();
                System.out.println(message);

                //读取从客户端发来的信息，这个信息马上发送给所有的客户端
                //所以，我们需要所有的能够发送给客户端信息的引用。
                for(BufferedWriter bw : list) {
                    bw.write( name + "对大家说：" + message);
                    bw.newLine();
                    bw.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
