package view.AdminView;

import Chat.test5.Server2;
import Chat.test5.ServerText;
import Execl.ExportRoominfo;
import Execl.ExportUserinfo;
import Execl.Importpeople;
import Execl.Importpeopletest;
import bean.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.RoomService;
import service.impl.RoomServiceImpl;
import view.AroudFood.Foodview1;
import view.AroudPhotoView.Photo1;
import view.AroudView.Roadview1;
import view.BuyView.BookroomView;
import view.BuyView.QueryRoomIfonView;
import view.ChatView.T1;
import view.PhotoMessageView.DeletePhotoView;
import view.PhotoMessageView.DisplayPhotoView;
import view.PhotoMessageView.UploadPhoto;
import view.RoomRoad.*;
import view.RoomType.*;
import view.Userview.*;

import java.util.List;

public class AdminView {



    public static void start(User user) {
        Stage stage=new Stage();



        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        root.setStyle("-fx-background-image: url(images/mishu.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);



        // File menu - new, save, exit
        Menu fileMenu = new Menu("菜单");
        MenuItem newMenuItem = new MenuItem("暂未开放");
        MenuItem saveMenuItem = new MenuItem("切换账号");
        MenuItem exitMenuItem = new MenuItem("退出");



        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView.loginView();
            }
        });

        //新建菜单
        Menu webMenu = new Menu("用户信息");
        CheckMenuItem lookMenuItem = new CheckMenuItem("查看用户信息");
        lookMenuItem.setSelected(true);
        webMenu.getItems().add(lookMenuItem);

        CheckMenuItem addMenuItem = new CheckMenuItem("增加用户");
        addMenuItem.setSelected(true);
        webMenu.getItems().add(addMenuItem);

        CheckMenuItem deleMenuItem = new CheckMenuItem("删除用户");
        deleMenuItem.setSelected(true);
        webMenu.getItems().add(deleMenuItem);

        lookMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UserManageView3.employee(user);
            }
        });
        addMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage stage=new Stage();
                    AdminAddview.start(stage);
                     stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        deleMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                Stage stage=new Stage();
                    DeleteView.start(stage);
                stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });





        //新建菜单
        Menu sqlMenu = new Menu("房间信息");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem bookItem = new RadioMenuItem("预订情况");
        bookItem.setToggleGroup(tGroup);
        RadioMenuItem rountItem = new RadioMenuItem("功能未完善");
        rountItem.setToggleGroup(tGroup);
        rountItem.setSelected(true);
        sqlMenu.getItems().addAll(bookItem,rountItem,
                new SeparatorMenuItem());

        bookItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BookinfoView.display();
            }
        });





        Menu tutorialManeu = new Menu("特色房型");
        CheckMenuItem check1 = new CheckMenuItem("双人标间");
        CheckMenuItem check2 = new CheckMenuItem("单人标间");
        CheckMenuItem check3 = new CheckMenuItem("情侣间");
        CheckMenuItem check4 = new CheckMenuItem("总统套房");
        CheckMenuItem check5 = new CheckMenuItem("亲子房");
        tutorialManeu.getItems().addAll(check1,check2,check3,check4,check5);



        Menu webMenu2 = new Menu("导出信息");
        CheckMenuItem exportuserMenuItem = new CheckMenuItem("用户信息导出");
        exportuserMenuItem.setSelected(true);
        webMenu2.getItems().add(exportuserMenuItem);
        CheckMenuItem exportroomMenuItem = new CheckMenuItem("房间信息导出");
        exportroomMenuItem.setSelected(true);
        webMenu2.getItems().add(exportroomMenuItem);
        CheckMenuItem impotrpeopleMenuItem = new CheckMenuItem("其他信息导入");
        impotrpeopleMenuItem.setSelected(true);
        webMenu2.getItems().add(impotrpeopleMenuItem);

        exportuserMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExportUserinfo.export();
            }
        });
        exportroomMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExportRoominfo.export();
            }
        });
        impotrpeopleMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Importpeopletest.impotrto();
            }
        });



        Menu chatMenu2 = new Menu("客服上线");
        CheckMenuItem onlinellMenuItem = new CheckMenuItem("点击上线",new ImageView("images/小熊3.png"));
        onlinellMenuItem.setSelected(true);
        chatMenu2.getItems().add(onlinellMenuItem);

        onlinellMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    T1.chatToUser(user.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        sqlMenu.getItems().add(tutorialManeu);

        menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu,webMenu2,chatMenu2);

        Startview.setTitle("管理员系统");

        //让scene对象设置到项目的stage
        Startview.setScene(scene);

        ServerText serverText = new ServerText();
        Thread thread = new Thread(serverText);
        thread.start();

    }


}
