package view.Userview;

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
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.Date;

public class AdminAddview {
    public static void start(Stage stage) throws Exception {
        GridPane gridPane=new GridPane();
        Label username=new Label("用户名:");
        Label password=new Label("密码:");
        Label password2=new Label("再次确定密码:");
        Label email=new Label("邮箱:");
        Label phone=new Label("手机号码:");

        TextField username1=new TextField();
        PasswordField password1=new PasswordField();
        PasswordField password3=new PasswordField();
        TextField email1=new TextField();
        TextField phone1=new TextField();

        Button right=new Button("添加");
        Button backbt=new Button("返回");

        gridPane.add(username,1,1);
        gridPane.add(password,1,2);
        gridPane.add(password2,1,3);
        gridPane.add(email,1,4);
        gridPane.add(phone,1,5);

        gridPane.add(username1,2,1);
        gridPane.add(password1,2,2);
        gridPane.add(password3,2,3);
        gridPane.add(email1,2,4);
        gridPane.add(phone1,2,5);


        gridPane.add(backbt,3,6);
        gridPane.add(right,2,6);
        right.setPrefSize(100,50);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(60,60,60,60));
        gridPane.setAlignment(Pos.CENTER);

        Image image2 = new Image("images/R-C.jpg");
        gridPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");




        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(password1.getText().equals("") ||password3.getText().equals("")||username1.equals("")){
                    System.out.println("账号密码不能为空");
                    try {
                        RegisterView.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {

                    if (password1.getText().equals(password3.getText()) ){

                        String name=username1.getText();
                        String password=password1.getText();
                        String email=email1.getText();
                        String phone=phone1.getText();
                        Date date=new Date();
                        User user1 = new User(name,password, (java.sql.Date) date,email,phone);

                        //创建业务对象，
                        UserService userService = new UserServiceImpl();
                        // 调用业务方法（把参数传入，得到业务结果）
                        userService.register(user1);



                    }else {

                        System.out.println("两次密码不一致，请重新输入");

                    }
                }}
        });

        backbt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // UserManageView3.employee();
                stage.close();
            }
        });




        //对于本类而言（作用是：显示register页面),经过页面设置到一个scene对象
        Scene scene = new Scene(gridPane, 800, 600);

        //开放对title设置
        Startview.setTitle("register page");

        //让scene对象设置到项目的stage
        stage.setScene(scene);
    }
}