package view.PhotoMessageView;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.PhotoService;
import service.impl.PhotoServiceImpl;
import view.BuyView.StoreView;
import view.Userview.Startview;


public class DeletePhotoView {
    public static void delete(String name,String password) {
        Stage stage=new Stage();
        GridPane gridPane = new GridPane();
        Label labelName = new Label("用户名:");
        Label labelPwd = new Label("密码:");
        TextField tfName = new TextField();
        PasswordField tfPwd = new PasswordField();
        tfName.setPromptText(name);
        tfPwd.setPromptText(password);
        gridPane.add(labelName,1,1);
        gridPane.add(tfName,2,1);
        gridPane.add(labelPwd,1,2);
        gridPane.add(tfPwd,2,2);




        Button deleteBtn = new Button("删除图片");
        Button backBtn = new Button("返回");


        deleteBtn.setStyle("-fx-background-color:#ff000000;");
        backBtn.setStyle("-fx-background-color:#ff000000;");




        gridPane.add(deleteBtn,1,3);
        gridPane.add(backBtn,2,3);

        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(60,60,60,60));
        gridPane.setAlignment(Pos.CENTER);
        //设置registBtn的位置
        gridPane.setMargin(deleteBtn,new Insets(0,0,0,0));


        Image image2 = new Image("images/R-C.jpg");
        gridPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");

        //“删除” 图片的事件
        deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PhotoService service=new PhotoServiceImpl();
                service.deleteByNP(name,password);
                System.out.println("删除成功");
            }
        });
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StoreView.start(name,password);
            }
        });



        //对于本类而言（作用是：显示login页面),经过页面设置到一个scene对象
        Scene scene = new Scene(gridPane, 800, 600);
        //开放对title设置
       // Startview.setTitle("删除页面");
        //让scene对象设置到项目的stage
        //Startview.setScene(scene);

        stage.setScene(scene);
        stage.show();

    }

}
