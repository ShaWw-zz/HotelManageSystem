package view.BuyView;

import bean.Room;
import bean.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;

public class LookRoomIfonView {

    //设置一个scene,最终让统一stage.set场景
    //表格
    public static void display(List<Room> roomList) {
        Stage stage=new Stage();
        //创建一个方位布局管理器
        BorderPane borderPane = new BorderPane();
        FlowPane flowPane=new FlowPane();

       /* Button outButton = new Button("退订");
        Button backButton = new Button("返回");
        flowPane.getChildren().add(outButton);
        flowPane.getChildren().add(backButton);*/


        //创建表格显示对象
        TableView tableView = new TableView<>();
        ObservableList<Room> data = FXCollections.observableArrayList(roomList);
        //传入数据
        tableView.setItems(data);

        //设置显示（表格每列的数据） 列的标题（String)与内容(数据中的显示的值）
        //需要一列一列的配置（设置列与data内容之间的映射）
        TableColumn<User, String> tableColumn1 = new TableColumn<>("roomnum");
        tableColumn1.setMinWidth(30);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("roomnum"));

        /*TableColumn<User, String> tableColumn2 = new TableColumn<>("username");
        tableColumn2.setMinWidth(30);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("username"));
*/
        TableColumn<User, String> tableColumn2 = new TableColumn<>("type");
        tableColumn2.setMinWidth(30);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<User, String> tableColumn3 = new TableColumn<>("price");
        tableColumn3.setMinWidth(30);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("price"));


       /* outButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OutRoomView.loginView();
            }
        });*/



        tableView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3);


        borderPane.setTop(flowPane);
       // borderPane.setBottom(backButton);
        borderPane.setCenter(tableView);


        Scene scene = new Scene(borderPane, 800, 800);


        stage.setTitle("剩余房间信息");
        stage.setScene(scene);
        stage.show();



       /* backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Room r1 = roomList.get(0);
                StoreView.start(r1.getUsername(),r1.getPassword());
                stage.close();
            }
        });*/
    }
}
