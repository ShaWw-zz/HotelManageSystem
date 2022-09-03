package view.BuyView;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBookFailView {

    private static boolean res;
    public static boolean display(String title){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label();
        label.setText("当前此房间没有空闲");
        Button btn1 = new Button("重新预订");

        btn1.setOnMouseClicked(event -> {
            res=true;
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
