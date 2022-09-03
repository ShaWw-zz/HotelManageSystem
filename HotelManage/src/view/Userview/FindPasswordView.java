package view.Userview;

import bean.User;
import dao.UserDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import service.UserService;
import service.impl.UserServiceImpl;

public class FindPasswordView {

    public static void start() throws Exception{
        GridPane gridPane=new GridPane();
        Label username=new Label("用户名:");
        Label email=new Label("邮箱:");
        Label phone=new Label("手机号码:");

        TextField username1=new TextField();
        TextField email1=new TextField();
        TextField phone1=new TextField();
        Button find=new Button("找回密码");
        Button back=new Button("返回登录");

        gridPane.add(username,1,1);
        gridPane.add(email,1,2);
        gridPane.add(phone,1,3);
        gridPane.add(username1,2,1);
        gridPane.add(email1,2,2);
        gridPane.add(phone1,2,3);
        gridPane.add(find,1,4);
        gridPane.add(back,2,4);
        gridPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(60,60,60,60));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setMargin(back,new Insets(0,0,0,115));

        find.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //创建业务对象，
                UserService userService = new UserServiceImpl();
                // 调用业务方法（把参数传入，得到业务结果）
                String password = userService.findByNEP(username1.getText(), email1.getText(), phone1.getText());

                if (password!="") {
                    try {
                    FindPasswordAlertView.display("找回密码", password);
                        FindPasswordView.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                    System.out.println("账号消息错误");
                        FindPasswordView.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView.loginView();
            }
        });










        //对于本类而言（作用是：显示register页面),经过页面设置到一个scene对象
        Scene scene = new Scene(gridPane, 800, 600);

        //开放对title设置
        Startview.setTitle("找回密码");

        //让scene对象设置到项目的stage
        Startview.setScene(scene);
    }
}
