package view.Userview;

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


import java.util.List;

public class UserManageView {

    //设置一个scene,最终让统一stage.set场景
    //表格
    public static void display(List<User> userList) {

        //创建一个方位布局管理器
        BorderPane borderPane = new BorderPane();
        FlowPane flowPane=new FlowPane();

        Button addButton = new Button("新增");
        Button backButton = new Button("返回");
        flowPane.getChildren().add(addButton);
        flowPane.getChildren().add(backButton);


        //创建表格显示对象
        TableView tableView = new TableView<>();
        ObservableList<User> data = FXCollections.observableArrayList(userList);
        //传入数据
        tableView.setItems(data);

        //设置显示（表格每列的数据） 列的标题（String)与内容(数据中的显示的值）
        //需要一列一列的配置（设置列与data内容之间的映射）
        TableColumn<User, String> tableColumn1 = new TableColumn<>("ID");
        tableColumn1.setMinWidth(30);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<User, String> tableColumn2 = new TableColumn<>("NAME");
        tableColumn2.setMinWidth(30);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> tableColumn3 = new TableColumn<>("PASSWORD");
        tableColumn3.setMinWidth(30);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<User, String> tableColumn4 = new TableColumn<>("CREATETIME");
        tableColumn4.setMinWidth(30);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("createTime"));

        TableColumn<User, String> tableColumn5 = new TableColumn<>("EMAIL");
        tableColumn5.setMinWidth(30);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<User, String> tableColumn6 = new TableColumn<>("PHONE");
        tableColumn6.setMinWidth(30);
        tableColumn6.setCellValueFactory(new PropertyValueFactory<>("phone"));


        tableView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3,tableColumn4,tableColumn5,tableColumn6);


        borderPane.setTop(flowPane);
       // borderPane.setBottom(backButton);
        borderPane.setCenter(tableView);


        Scene scene = new Scene(borderPane, 500, 400);

        Startview.setTitle("user manage");
        Startview.setScene(scene);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                UserManageView3.employee();
            }
        });
    }
}
