package view.Userview;

import Chat.test5.Server2;
import Chat.test5.ServerText;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Startview extends Application {

    private  static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    public  static void setScene(Scene scene){
        Startview.stage.setScene(scene);

    }
    public static void setTitle(String title){
        Startview.stage.setTitle(title);
    }
    public void start(Stage stage) throws Exception {
        Startview.stage = stage;

        BorderPane borderPane = new BorderPane();
        Button button = new Button("");
        button.setPrefSize(200,100);

        //Image image = new Image("images/R-C.jpg");
        borderPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");
        // borderPane.setCenter(image);
        //gridPane.setStyle("-fx-background-image:url('images/dxLogin.jpg'); -fx-background-repeat: no-repeat;-fx-background-size: 965 434; -fx-background-position: center center;");
        //borderPane.setBottom(button);
        button.setStyle("-fx-background-color:#ff000000;"+         //设置背景颜色
                        "-fx-border-radius:20;"+         //设置边框圆角
                "-fx-font-size: 0");
        button.setMaxSize(800,600);

        borderPane.setCenter(button);
        Scene scene = new Scene(borderPane,800,600);
        stage.setTitle("酒店管理系统");
        stage.setScene(scene);
        stage.show();






        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {
                 System.out.println("hello there, click me");
                LoginView.loginView();
            }
        });





        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent windowEvent) {
                System.out.println("shutdown");
                System.exit(0);
            }
        });


    }
}
