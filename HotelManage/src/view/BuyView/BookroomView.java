package view.BuyView;

import bean.Room;
import bean.User;
import dao.RoomDao;
import dao.impl.RoomDaoImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.RoomService;
import service.UserService;
import service.impl.RoomServiceImpl;
import service.impl.UserServiceImpl;
import view.Userview.Startview;

import javax.swing.*;

public class BookroomView  {


    public  static void start(String username,String password) {
        GridPane gridPane = new GridPane();

        FlowPane fp = new FlowPane();
        fp.setStyle("-fx-background-image: url(images/12.jpeg); -fx-background-repeat: no-repeat;-fx-background-size: 800 600; -fx-background-position: center center;");

        ChoiceBox<Object> cb = new ChoiceBox<>();
        cb.setItems(FXCollections.observableArrayList(
                "双人标间", "单人标间 ",
               /* new Separator(),*/ "情趣房", "总统套房","亲子房")
        );

        final String [] greeting = {"双人标间", "单人标间 ","情侣房", "总统套房","亲子房"};
        final String [] greeting2 = {"双人标间:一天400元", "单人标间:一天300元 ","情侣房:一天700元", "总统套房:一天1000元","亲子房:一天600元"};

        final Label label = new Label();
        Button look=new Button("查看剩余房间");
        Button bookbutton=new Button("确认预订");
        Button back=new Button("返回");

        look.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RoomDao roomDao=new RoomDaoImpl();

            LookRoomIfonView.display(roomDao.lookroom());

            }
        });


      bookbutton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              String type= (String) cb.getValue();
              //创建业务对象，
              RoomService roomService = new RoomServiceImpl();
              Room r = roomService.findBytype(type);
              System.out.println(r.getUsername());
              if (r.getUsername().equals("未预订")){
                  // 调用业务方法（把参数传入，得到业务结果）
                  roomService.updateBytype(type,username,password);
                  int a=roomService.findprice(type);
                  JOptionPane.showMessageDialog(null,"正在预订："+a+"/天");
              }else {
                  System.out.println("当前此房间没有空闲");
                  AlertBookFailView.display("预订失败");
              }

          }
      });

        cb.setTooltip(new Tooltip("Select The Roomtype"));

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StoreView.start(username,password);
            }
        });

        gridPane.setMargin(bookbutton,new Insets(0,0,0,190));
        fp.getChildren().add(cb);
        fp.getChildren().add(label);
        fp.getChildren().add(bookbutton);
        fp.getChildren().add(look);
        fp.getChildren().add(back);
        fp.setAlignment(Pos.CENTER);


        Scene scene = new Scene(fp,800,600);

        //让scene对象设置到项目的stage
        Startview.setScene(scene);



    }
}
