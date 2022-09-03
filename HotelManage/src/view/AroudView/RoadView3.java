package view.AroudView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RoadView3 {
    public  static void start() throws Exception {
        Stage stage=new Stage();
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-image: url(images/luyouluxian3.png); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");


        Button nextbutton = new Button("");
        nextbutton.setPrefSize(200,100);

        nextbutton.setStyle("-fx-background-color:#ff000000;"+         //设置背景颜色
                "-fx-border-radius:20;"+         //设置边框圆角

                "-fx-font-size: 0");
        nextbutton.setMaxSize(800,600);
        borderPane.setMargin(nextbutton,new Insets(0,0,0,400));


        Button lastbutton = new Button("");
        lastbutton.setPrefSize(200,100);

        lastbutton.setStyle("-fx-background-color:#ff000000;"+         //设置背景颜色
                "-fx-border-radius:20;"+         //设置边框圆角

                "-fx-font-size: 0");
        lastbutton.setMaxSize(400,600);


        lastbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    RoadView2.start();
                } catch (Exception e) {

                }
            }
        });
        nextbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        borderPane.setCenter(nextbutton);
        Scene scene = new Scene(borderPane,800,600);
        stage.setTitle("路线图");
        stage.setScene(scene);
        stage.show();

    }
}
