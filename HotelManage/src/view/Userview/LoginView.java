package view.Userview;

import Chat.test5.Server;
import Chat.test5.Server2;
import bean.User;
import dao.impl.UserDaoImpl;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import service.UserService;
import service.impl.UserServiceImpl;
import view.AdminView.AdminView;
import view.BuyView.BookroomView;
import view.BuyView.StoreView;

import java.util.List;
import java.util.Random;

public class LoginView {



    public static void loginView() {

        GridPane gridPane = new GridPane();
        Label labelName = new Label("用户名:");
        Label labelPwd = new Label("密码:");
        TextField tfName = new TextField();
        PasswordField tfPwd = new PasswordField();
        Text t=new Text();
        t.setText(common.Random.random());
        TextField random = new TextField();
        t.setStyle("-fx-text-fill:red;" +"-fx-font-weight:bold;"+"-fx-font-size: 22;");
        random.setPromptText("请正确输入左侧验证码");
        gridPane.add(labelName,1,1);
        gridPane.add(tfName,2,1);
        gridPane.add(labelPwd,1,2);
        gridPane.add(tfPwd,2,2);
        gridPane.add(t,1,3);
        gridPane.add(random,2,3);



        Button loginBtn = new Button("登录");
        Button registBtn = new Button("注册");
        Button findpassword = new Button("找回密码");
        Button re=new Button("看不清，换一下！");
        loginBtn.setStyle("-fx-background-color:#ff000000;");
        registBtn.setStyle("-fx-background-color:#ff000000;");
        findpassword.setStyle("-fx-background-color:#ff000000;");



        gridPane.add(loginBtn,1,4);
        gridPane.add(registBtn,2,4);
        gridPane.add(findpassword,3,4);
        gridPane.add(re,3,3);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(60,60,60,60));
        gridPane.setAlignment(Pos.CENTER);
        //设置registBtn的位置
        gridPane.setMargin(registBtn,new Insets(0,0,0,90));


        Image image2 = new Image("images/R-C.jpg");
        gridPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");



        re.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView.loginView();
            }
        });

        //“注册” 登入的事件
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String username = tfName.getText();
                String password = tfPwd.getText();
                System.out.println(username + ":" + password);
                //创建业务对象，
                UserService userService = new UserServiceImpl();
                // 调用业务方法（把参数传入，得到业务结果）
                User user = userService.login(username, password);
               //StudentManageView.studentManageView();
                if (user!=null){
                   if (random.getText().equals("")){
                       System.out.println("验证码不能为空");
                   }else if (random.getText().equals(t.getText())){
                       if (username.equals("admin")) {
                           AdminView.start(user);
                       } else {
                           StoreView.start(username, password);
                       }
                   }else {
                       System.out.println("验证码错误");
                       LoginView.loginView();
                   }
                }else {
                    System.out.println("登录失败。请检查账户密码");

                }
            }
        });


        registBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    RegisterView.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        findpassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FindPasswordView.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




        //对于本类而言（作用是：显示login页面),经过页面设置到一个scene对象
        Scene scene = new Scene(gridPane, 800, 600);

        //开放对title设置
        Startview.setTitle("登录页面");

        //让scene对象设置到项目的stage
        Startview.setScene(scene);

    }
}
