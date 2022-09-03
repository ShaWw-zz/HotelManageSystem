package view.Userview;

import bean.User;
import common.Costant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.List;

public class UserManageView2 {

    public static void employee(){
        employee(null);
    }

    public static void employee(User user){
        UserService employeeService = new UserServiceImpl();

        BorderPane root = new BorderPane();

        // MenuBar menuBar = MenuView.menuBar();

        VBox top = new VBox();
        //   menuBar.setBackground(Background.fill(Color.TRANSPARENT));

        HBox search = new HBox(5);

        search.setPadding(new Insets(15,5,5,35));
//        Label searchUserName = new Label("用户名");
        TextField ename = new TextField();

        ename.setPromptText("请输入用户名");

        DatePicker startTimePicker = new DatePicker();
        startTimePicker.setPromptText("起始时间");
        DatePicker endTimePicker = new DatePicker();
        endTimePicker.setPromptText("结束时间");



        Button addButton = new Button("新增");
        addButton.setStyle("-fx-background-color: #9ACD32;");
        addButton.setTextFill(Color.valueOf("#fcf7f7"));
        addButton.setOnAction(actionEvent->{
            //EmployeeAddView.add(null);
        });

        //search.getChildren().addAll(ename,startTimePicker,endTimePicker,searchButton,addButton);

        //top.getChildren().addAll(menuBar,search);

        //root.setTop(top);

        Pagination pagination = new Pagination(employeeService.getTotalPage(user), 0);


        pagination.setPageFactory((Integer pageIndex) -> {
            return createPage(pageIndex+1,Costant.PAGE_SIZE,user);
        });

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);

        root.setCenter(anchor);
        Scene scene = new Scene(root, 900, 500, Color.WHITE);

        Startview.setScene(scene);

    }
    public static VBox createPage(Integer currentPage, Integer pageSize, User user) {
        UserService employeeService = new UserServiceImpl();

        //生产数据
        ObservableList<User> data =
                FXCollections.observableArrayList(
                        employeeService.page(currentPage,pageSize,user)
                );

        VBox vBox = new VBox();
        TableView tableView = new TableView<>();
        vBox.setAlignment(Pos.CENTER);//内容居中
        vBox.getChildren().add(tableView);//加入到根布局
        //tableView.setEditable(true);//表格可编辑
        //主键ID
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



        tableView.setItems(data);
        tableView.getColumns().addAll(
                tableColumn1,
                tableColumn2,
                tableColumn3,
                tableColumn4,
                tableColumn5,
                tableColumn6

        );
        // 设置数据源
        return vBox;
    }



}
