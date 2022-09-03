package view.BuyView;

import bean.User;
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
import service.RoomService;
import service.UserService;
import service.impl.RoomServiceImpl;
import service.impl.UserServiceImpl;
import view.AdminView.AdminView;
import view.Userview.FindPasswordView;
import view.Userview.RegisterView;
import view.Userview.Startview;

import javax.swing.*;

public class OutRoomView {



    public static void loginView() {
        Stage stage=new Stage();

        GridPane gridPane = new GridPane();
        Label roomNum = new Label("房间号:");
        Label labelName = new Label("用户名:");
        Label labelPwd = new Label("密码:");
        TextField room = new TextField();
        TextField tfName = new TextField();
        PasswordField tfPwd = new PasswordField();

        gridPane.add(roomNum,1,1);
        gridPane.add(labelName,1,2);
        gridPane.add(labelPwd,1,3);
        gridPane.add(room,2,1);
        gridPane.add(tfName,2,2);
        gridPane.add(tfPwd,2,3);




       // Button loginBtn = new Button("登录");
        Button registBtn = new Button("确定取消");
       // Button findpassword = new Button("找回密码");

        //loginBtn.setStyle("-fx-background-color:#ff000000;");
        registBtn.setStyle("-fx-background-color:#ff000000;");
        //findpassword.setStyle("-fx-background-color:#ff000000;");



        //gridPane.add(loginBtn,1,3);
        gridPane.add(registBtn,2,4);
       // gridPane.add(findpassword,3,3);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(60,60,60,60));
        gridPane.setAlignment(Pos.CENTER);
        //设置registBtn的位置
        gridPane.setMargin(registBtn,new Insets(0,0,0,90));


        Image image2 = new Image("images/R-C.jpg");
        gridPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");

        //“注册” 登入的事件


        registBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {

                    int roomText = Integer.parseInt(room.getText());
                    String text = tfName.getText();
                    String tfPwdText = tfPwd.getText();
                    if (roomText==0||text.equals("")||tfPwdText.equals("")){
                        System.out.println("信息异常。请重试");
                        OutRoomView.loginView();
                    }else {

                    RoomService roomService=new RoomServiceImpl();
                    roomService.roomout(roomText,text,tfPwdText);
                    JOptionPane.showMessageDialog(null,"退房成功");}

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




        //对于本类而言（作用是：显示login页面),经过页面设置到一个scene对象
        Scene scene = new Scene(gridPane, 800, 600);

        //开放对title设置
        stage.setTitle("退房页面");

        //让scene对象设置到项目的stage
        stage.setScene(scene);
        stage.show();

    }
}
