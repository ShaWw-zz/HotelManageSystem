package view.Userview;

import bean.User;
import javafx.application.Application;
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

public class DeleteView  {
    public static void start(Stage stage) throws Exception {

        GridPane gridPane=new GridPane();
        Label id=new Label("id:");
        Label username=new Label("用户名:");
        Label password=new Label("密码:");
        Label password2=new Label("再次确定密码:");

        TextField id1=new TextField();
        TextField username1=new TextField();
        PasswordField password1=new PasswordField();
        PasswordField password3=new PasswordField();
        TextField email1=new TextField();
        TextField phone1=new TextField();

        Button del=new Button("删除");
        Button backbt=new Button("返回");

        gridPane.add(id,1,1);
        gridPane.add(username,1,2);
        gridPane.add(password,1,3);
        gridPane.add(password2,1,4);

        gridPane.add(username1,2,2);
        gridPane.add(password1,2,3);
        gridPane.add(password3,2,4);
        gridPane.add(id1,2,1);



        gridPane.add(backbt,3,6);
        gridPane.add(del,2,6);
        del.setPrefSize(100,50);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(60,60,60,60));
        gridPane.setAlignment(Pos.CENTER);

        Image image2 = new Image("images/R-C.jpg");
        gridPane.setStyle("-fx-background-image: url(images/R-C.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");






        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(password1.getText().equals("") ||password3.getText().equals("")||username1.equals("")){
                    System.out.println("账号密码不能为空");

                }else {

                    if (password1.getText().equals(password3.getText()) ){

                        String name=username1.getText();
                        String password=password1.getText();
                        int id=Integer.parseInt(id1.getText());


                        //创建业务对象，
                        UserService userService = new UserServiceImpl();
                        // 调用业务方法（把参数传入，得到业务结果）
                        userService.deteleByAll(id,name,password);


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


