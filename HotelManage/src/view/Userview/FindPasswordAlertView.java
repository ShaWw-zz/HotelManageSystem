package view.Userview;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FindPasswordAlertView {

    private static boolean res;
    public static boolean display(String title,String password){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label();
        label.setText("找回密码成功!密码为："+password);
        Button btn1 = new Button("记住了");

        btn1.setOnMouseClicked(event -> {
            res=true;
            System.out.println("你记住了密码为："+password);
            stage.close();
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label,btn1);
        //设置居中
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox,300,300);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.showAndWait();

        return res;
    }


}
