package view.RoomRoad;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.AroudView.RoadView2;

public class H1801View {
    public  static void start() throws Exception {
        Stage stage=new Stage();
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-image: url(images/1801xianlu.png); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");


        javafx.scene.control.Button nextbutton = new Button("");
        nextbutton.setPrefSize(200,100);

        nextbutton.setStyle("-fx-background-color:#ff000000;"+         //设置背景颜色
                "-fx-border-radius:20;"+         //设置边框圆角

                "-fx-font-size: 0");
        nextbutton.setMaxSize(800,600);
        borderPane.setMargin(nextbutton,new Insets(0,0,0,400));


        nextbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    stage.close();
                } catch (Exception e) {

                }
            }
        });

        borderPane.setCenter(nextbutton);
        Scene scene = new Scene(borderPane,800,600);
        stage.setTitle("1801位置");
        stage.setScene(scene);
        stage.show();

    }
}
