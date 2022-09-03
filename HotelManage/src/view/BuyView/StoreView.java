package view.BuyView;

import Chat.test5.Server2;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.RoomService;
import service.UserService;
import service.impl.RoomServiceImpl;
import service.impl.UserServiceImpl;
import view.AroudFood.Foodview1;
import view.AroudPhotoView.Photo1;
import view.AroudView.Roadview1;
import view.ChatView.T1;
import view.ChatView.T2;
import view.PhotoMessageView.DeletePhotoView;
import view.PhotoMessageView.DisplayPhotoView;
import view.PhotoMessageView.UploadPhoto;
import view.RoomRoad.*;
import view.RoomType.*;
import view.Userview.DeleteView;
import view.Userview.LoginView;
import view.Userview.Startview;
import view.Userview.UserUpdateView;


import java.util.List;


public class StoreView   {



    public static void start(String username,String password) {
        Stage stage=new Stage();



        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        root.setStyle("-fx-background-image: url(images/11.jpg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);



        // File menu - new, save, exit
        Menu fileMenu = new Menu("菜单");
        MenuItem newMenuItem = new MenuItem("修改个人信息");
        MenuItem deMenuItem = new MenuItem("注销账号");
        MenuItem saveMenuItem = new MenuItem("切换账号");

        MenuItem exitMenuItem = new MenuItem("退出");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        exitMenuItem.setAccelerator(KeyCombination.valueOf("ctrl+e"));

        fileMenu.getItems().addAll(newMenuItem, deMenuItem,saveMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        deMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage1=new Stage();
                try {
                    DeleteView.start(stage);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginView.loginView();
            }
        });
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UserService userService=new UserServiceImpl();
                UserUpdateView.add(userService.findByNameAndPwd(username,password));
            }
        });

        //新建菜单
        Menu webMenu = new Menu("周边景点");
        CheckMenuItem luxianMenuItem = new CheckMenuItem("一日游路线图");
        luxianMenuItem.setSelected(true);
        webMenu.getItems().add(luxianMenuItem);

        CheckMenuItem foodMenuItem = new CheckMenuItem("周边美食");
        foodMenuItem.setSelected(true);
        webMenu.getItems().add(foodMenuItem);

        CheckMenuItem ptotoMenuItem = new CheckMenuItem("周边美景—拍照超好看");
        ptotoMenuItem.setSelected(true);
        webMenu.getItems().add(ptotoMenuItem);

        ptotoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Photo1.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        luxianMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Roadview1.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        foodMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Foodview1.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });






        //新建菜单
        Menu sqlMenu = new Menu("订房系统");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem bookItem = new RadioMenuItem("预订房间");
        bookItem.setToggleGroup(tGroup);
        RadioMenuItem bookinfoItem = new RadioMenuItem("预订信息");
        bookinfoItem.setToggleGroup(tGroup);
        RadioMenuItem outroom = new RadioMenuItem("退房");
        bookinfoItem.setToggleGroup(tGroup);
        RadioMenuItem rountItem = new RadioMenuItem("您的房间路线");
        rountItem.setToggleGroup(tGroup);
        rountItem.setSelected(true);
        sqlMenu.getItems().addAll(bookItem, bookinfoItem,outroom,rountItem,
                new SeparatorMenuItem());


        outroom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OutRoomView.loginView();
            }
        });

        bookinfoItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            //QueryRoomInfoview
                RoomService roomService = new RoomServiceImpl();
                QueryRoomIfonView.display(roomService.queryAllByNP(username,password));

            }
        });



        rountItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //创建业务对象，
                RoomService roomService = new RoomServiceImpl();

                List list = roomService.findByusername(username);
                for (Object s:list
                     ) {
                    if (s.equals("1801")){
                        try {
                            H1801View.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (s.equals("1802")){
                        try {
                            H1802View.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (s.equals("1803")){
                        try {
                            H1803View.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (s.equals("1804")){
                        try {
                            H1804View.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (s.equals("1805")){
                        try {
                            H1805View.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });




        Menu tutorialManeu = new Menu("特色房型");
        CheckMenuItem check1 = new CheckMenuItem("双人标间");
        CheckMenuItem check2 = new CheckMenuItem("单人标间");
        CheckMenuItem check3 = new CheckMenuItem("情侣间");
        CheckMenuItem check4 = new CheckMenuItem("总统套房");
        CheckMenuItem check5 = new CheckMenuItem("亲子房");
        tutorialManeu.getItems().addAll(check1,check2,check3,check4,check5);

        check1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ShuangrenRoomView.start();
            }
        });
        check2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DanrenRoomView.start();
            }
        });
        check3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                QinglvRoomView.start();

            }
        });
        check4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ZongtongRoomView.start();

            }
        });
        check5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                QinziRoomView.start();

            }
        });

        bookItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                BookroomView.start(username, password);
            }
        });


        Menu webMenu2 = new Menu("美图留念");
        CheckMenuItem photowallMenuItem = new CheckMenuItem("照片墙");
        photowallMenuItem.setSelected(true);
        webMenu2.getItems().add(photowallMenuItem);
        CheckMenuItem photoMenuItem = new CheckMenuItem("照片上传");
        photoMenuItem.setSelected(true);
        webMenu2.getItems().add(photoMenuItem);
        CheckMenuItem xiugaiphotoMenuItem = new CheckMenuItem("照片删除");
        xiugaiphotoMenuItem.setSelected(true);
        webMenu2.getItems().add(xiugaiphotoMenuItem);

        xiugaiphotoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DeletePhotoView.delete(username,password);
            }
        });



        photowallMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayPhotoView.start();
            }
        });

        photoMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UploadPhoto.start(username,password);
            }
        });

        Menu madouMenu = new Menu("");
        Menu tutorialManeu2 = new Menu("",new ImageView("images/美女 (1).png" ));
        Menu tutorialManeu3 = new Menu("",new ImageView("images/小熊.png" ));
        Menu tutorialManeu4 = new Menu("",new ImageView("images/小熊2.png" ));
        Menu tutorialManeu5 = new Menu("",new ImageView("images/小熊3.png" ));
        CheckMenuItem check6 = new CheckMenuItem("付费观看");
        tutorialManeu2.getItems().addAll(check6);
        madouMenu.getItems().addAll(tutorialManeu2,tutorialManeu3,tutorialManeu4,tutorialManeu5);


        Menu chattMenu2 = new Menu("联系客服");
        CheckMenuItem goMenuItem = new CheckMenuItem("点击连接");
        goMenuItem.setSelected(true);
        chattMenu2.getItems().add(goMenuItem);
        goMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    T2.chatToUser(username);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        sqlMenu.getItems().add(tutorialManeu);
        menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu,webMenu2,madouMenu,chattMenu2);


        //让scene对象设置到项目的stage
        Startview.setScene(scene);
    }


}
