package view.ChatView;

import Chat.test5.ClientRead;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class T2 {



    public  static void chatToUser(String username) throws Exception {
        //User user = new User("hee", "123456", "10020", "123123");
        Stage stage = new Stage();
        BorderPane borderPane = new BorderPane();

        HBox hBox = new HBox();

        Text userText = new Text();
        TextArea chatWindow = new TextArea();
        TextArea userInput = new TextArea();

        userText.setText("你好：" + username);
        userInput.setMaxSize(251, 100);

        Button send = new Button("发送");


        Socket socket = new Socket("localhost", 8234);
        userInput.appendText("\t\n");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        new Thread(new ClientRead(socket, chatWindow)).start();

        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(userInput, send);
        borderPane.setTop(userText);
        borderPane.setCenter(chatWindow);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 400, 600);
       stage.setTitle("聊天室");
       stage.setScene(scene);
       stage.show();
        send.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String message = userInput.getText();
                try {
                    bw.write(username + ":" + message);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                userInput.setText("");

            }
        });

    }}

