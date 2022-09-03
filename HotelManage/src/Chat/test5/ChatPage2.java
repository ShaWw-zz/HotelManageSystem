package Chat.test5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatPage2 {

    public static void display2(String nickName) throws IOException {
        Stage stage = Loginpage2.getStage();

        TextArea ta = new TextArea();
        Socket socket = new Socket("localhost",6000);
      //  System.out.println("client link successful.");
        ta.appendText("连接成功");
        ta.appendText("\t\n");

        //获取字符缓冲写出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(nickName);
        bw.newLine();
        bw.flush();

        new Thread(new ClientRead(socket, ta)).start();

        //流式布局管理器(Container容器)
        FlowPane layout = new FlowPane();
        //  BorderPane layout = new BorderPane();

        //创建一个按钮组件（Node)
        Button button = new Button("send");
        button.setPrefSize(50,30);

        TextField tf = new TextField();
        tf.setPrefWidth(200);

        ta.setPrefColumnCount(50);
        ta.setPrefRowCount(30);



        layout.getChildren().add(ta);
        layout.getChildren().add(tf);
        layout.getChildren().add(button);



        //创建一个场景,指定布局管理器和大小
        Scene scene = new Scene(layout, 400, 700);
        //设置场景到舞台中
        stage.setScene(scene);
        stage.setTitle("chat room,welcome:" + nickName);
        //显示舞台
        stage.show();

        //发送信息的按钮
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String message = tf.getText();
                try {
                    bw.write(message);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tf.setText("");
            }
        });
    }


}
