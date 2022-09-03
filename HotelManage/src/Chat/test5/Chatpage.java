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

public class Chatpage {
    public static void display(String nickname) throws IOException {
        Stage stage=Loginpage.getStage();
        TextArea ta=new TextArea();
        Socket socket = new Socket("localhost",6000);
        //  System.out.println("client link successful.");
        ta.appendText("连接成功");
        ta.appendText("\t\n");


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(nickname);
        bw.newLine();
        bw.flush();

        new Thread(new ClientRead(socket,ta)).start();


        FlowPane flowPane=new FlowPane();

        Button button = new Button("send");
        button.setPrefSize(50,30);

        TextField tf = new TextField();
        tf.setPrefWidth(200);

        ta.setPrefColumnCount(50);
        ta.setPrefRowCount(30);



        flowPane.getChildren().add(ta);
        flowPane.getChildren().add(tf);
        flowPane.getChildren().add(button);

        Scene scene=new Scene(flowPane,400,700);
        stage.setScene(scene);
        stage.setTitle("chat room,welcome:" + nickname);
        stage.show();


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String message=tf.getText();
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
