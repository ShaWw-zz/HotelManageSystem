package Chat.test5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Loginpage extends Application {
    private static Stage stage;

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public static Stage getStage() {
        return stage;
    }

    public void start(Stage stage) throws Exception {
        Loginpage.stage=stage;
        FlowPane flowPane=new FlowPane();
        javafx.scene.control.Button b1=new javafx.scene.control.Button("login");
        b1.setPrefSize(100,50);
        javafx.scene.control.Label label=new javafx.scene.control.Label("请输入昵称");
        TextField textField=new TextField();
        textField.setPrefWidth(200);

        flowPane.getChildren().add(b1);
        flowPane.getChildren().add(label);
        flowPane.getChildren().add(textField);


        Scene scene=new Scene(flowPane,500,400);
        stage.setScene(scene);
        stage.show();



        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String nickname=textField.getText();

                try {
                    Chatpage.display(nickname);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });





    }

    public static void main(String[] args) {
launch(args);
    }
}
