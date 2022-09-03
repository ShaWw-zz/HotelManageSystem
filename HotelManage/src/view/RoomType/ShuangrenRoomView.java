package view.RoomType;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShuangrenRoomView   {


    public static void start()  {
        Stage stage=new Stage();
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-image: url(images/shuangren.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");


        Button button = new Button("");
        button.setPrefSize(200,100);
        button.setStyle("-fx-background-color:#ff000000;"+         //设置背景颜色
                "-fx-border-radius:20;"+         //设置边框圆角

                "-fx-font-size: 0");
        button.setMaxSize(800,600);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });




        borderPane.setCenter(button);
        Scene scene = new Scene(borderPane,800,600);
        stage.setTitle("路线图");
        stage.setScene(scene);
        stage.show();


    }


}
