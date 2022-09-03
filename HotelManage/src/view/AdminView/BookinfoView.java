package view.AdminView;

import bean.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.RoomService;
import service.impl.RoomServiceImpl;


import java.util.List;

public class BookinfoView {
    public static void display() {
        Stage stage=new Stage();
        HBox search = new HBox(15);
        search.setPadding(new Insets(5,0,0,30));
        RoomService roomService=new RoomServiceImpl();
        List<Room> roomList = roomService.queryAll();


        //创建一个方位布局管理器
        BorderPane borderPane = new BorderPane();
        FlowPane flowPane=new FlowPane();

        Button addButton = new Button("新增");
        Button backButton = new Button("返回");
        Button fluashButton = new Button("刷新");

        search.getChildren().addAll(addButton,backButton,fluashButton);


        /*flowPane.getChildren().add(addButton);
        flowPane.getChildren().add(backButton);
        flowPane.getChildren().add(fluashButton);*/

        addButton.setStyle("-fx-background-color: #9ACD32;");
        addButton.setTextFill(Color.valueOf("#fcf7f7"));
        backButton.setStyle("-fx-background-color: #9ACD32;");
        backButton.setTextFill(Color.valueOf("#fcf7f7"));
       fluashButton.setStyle("-fx-background-color: #9ACD32;");
       fluashButton.setTextFill(Color.valueOf("#fcf7f7"));

        fluashButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BookinfoView.display();
                stage.close();
            }
        });


        //创建表格显示对象
        TableView tableView = new TableView<>();
        ObservableList<Room> data = FXCollections.observableArrayList(roomList);
        for (Room r:data) {
            System.out.println(r);
        }


        //传入数据
        tableView.setItems(data);

        //设置显示（表格每列的数据） 列的标题（String)与内容(数据中的显示的值）
        //需要一列一列的配置（设置列与data内容之间的映射）
        TableColumn<Room, String> tableColumn1 = new TableColumn<>("房间号");
        tableColumn1.setMinWidth(30);
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("roomnum"));

        TableColumn<Room, String> tableColumn2 = new TableColumn<>("用户名");
        tableColumn2.setMinWidth(30);
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Room, String> tableColumn3 = new TableColumn<>("密码");
        tableColumn3.setMinWidth(30);
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("password"));

        //<S,T> S:泛型的类型   T:单元格类型
        TableColumn<Room, String> tableColumn4 = new TableColumn<>("类型");
        tableColumn4.setMinWidth(30);
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Room, String> tableColumn5 = new TableColumn<>("价格/天");
        tableColumn5.setMinWidth(30);
        tableColumn5.setCellValueFactory(new PropertyValueFactory<>("price"));
        //System.out.println(new PropertyValueFactory<>("price"));


        //编辑
        TableColumn<Room, Integer> tableColumn6 = new TableColumn<>("取消预订");
        // 设置宽度
        tableColumn6.setMinWidth(60);
        // 设置按钮
        tableColumn6.setCellFactory(new Callback<TableColumn<Room, Integer>, TableCell<Room, Integer>>() {
            @Override
            public TableCell<Room, Integer> call(TableColumn<Room, Integer> param) {
                Button btn = new Button("取消预订");

                TableCell<Room,Integer> cell = new TableCell<Room,Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            Room employee = getTableView().getItems().get(getIndex());
                            int id = employee.getRoomnum();
                            btn.setOnAction(actionEvent->{
                               roomService.cancelbook(id);
                               BookinfoView.display();
                               stage.close();
                            });
                            setGraphic(btn);//设置按钮
                            setText(null);//清空文本
                        }

                    }
                };

                return cell;
            }
        });
        //编辑
        TableColumn<Room, Integer> tableColumn7 = new TableColumn<>("修改");
        // 设置宽度
        tableColumn7.setMinWidth(60);
        // 设置按钮
        tableColumn7.setCellFactory(new Callback<TableColumn<Room, Integer>, TableCell<Room, Integer>>() {
            @Override
            public TableCell<Room, Integer> call(TableColumn<Room, Integer> param) {
                Button btn2 = new Button("修改");

                TableCell<Room,Integer> cell = new TableCell<Room,Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn2.setOnAction(actionEvent->{
                                Room employee = getTableView().getItems().get(getIndex());
                                UpdaetPriceView.loginView(employee.getRoomnum(),employee.getType());
                                //int id = employee.getId();
                                //EmployeeAddView.add(id);
                            });
                            setGraphic(btn2);//设置按钮
                            setText(null);//清空文本
                        }

                    }
                };

                return cell;
            }
        });



        tableView.getColumns().addAll(tableColumn1,tableColumn2,tableColumn3,tableColumn4,tableColumn5,tableColumn6,tableColumn7);


        borderPane.setTop(search);
        // borderPane.setBottom(backButton);
        borderPane.setCenter(tableView);

        //borderPane.getChildren().add(search);
        Scene scene = new Scene(borderPane, 600, 500);

        stage.setTitle("Book manage");
        stage.setScene(scene);
        stage.show();

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
    }

}
