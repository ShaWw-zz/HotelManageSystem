package view.Userview;

import bean.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import common.Costant;
import dao.impl.UserDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.UserService;
import service.impl.UserServiceImpl;
import view.AdminView.AdminView;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;


public class UserManageView3 {

    public static void employee(){
        employee(null);
    }

    public static void employee(User user){
        UserService employeeService = new UserServiceImpl();

        BorderPane root = new BorderPane();

        VBox top = new VBox();
        HBox search = new HBox(5);
        search.setPadding(new Insets(5,0,0,30));
        Button add=new Button("增加");
        Button del=new Button("删除");
        Button fin=new Button("时间查询");
        Button back=new Button("返回");
        Button findbyusername=new Button("用户名查询");
        Button update=new Button("修改");

        Button flush=new Button("刷新");
        add.setStyle("-fx-background-color: #9ACD32;");
        add.setTextFill(Color.valueOf("#fcf7f7"));
        del.setStyle("-fx-background-color: #9ACD32;");
        del.setTextFill(Color.valueOf("#fcf7f7"));
        fin.setStyle("-fx-background-color: #9ACD32;");
        fin.setTextFill(Color.valueOf("#fcf7f7"));
        back.setStyle("-fx-background-color: #9ACD32;");
        back.setTextFill(Color.valueOf("#fcf7f7"));
        findbyusername.setStyle("-fx-background-color: #9ACD32;");
        findbyusername.setTextFill(Color.valueOf("#fcf7f7"));
        flush.setStyle("-fx-background-color: #9ACD32;");
        flush.setTextFill(Color.valueOf("#fcf7f7"));
        update.setStyle("-fx-background-color: #9ACD32;");
        update.setTextFill(Color.valueOf("#fcf7f7"));
        DatePicker checkInDatePicker = new DatePicker();
        DatePicker checkInDatePicker2 = new DatePicker();
        TextField textField=new TextField("请输入用户名");



        findbyusername.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //创建业务对象，
                UserService userService = new UserServiceImpl();
                // 调用业务方法（把参数传入，得到业务结果）
                FindByNameView.display(userService.findByName(textField.getText()));
            }
        });




        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // LoginView.loginView();
                AdminView.start(user);
            }
        });


        fin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkInDatePicker.getValue()==null) {
                    System.out.println("查询时间不能为空");
                    UserManageView3.employee();
                }
                else {
                //创建业务对象，
                UserService userService = new UserServiceImpl();
                // 调用业务方法（把参数传入，得到业务结果）
                UserManageView.display(userService.findByTime(checkInDatePicker.getValue().toString(),checkInDatePicker2.getValue().toString()));
                }}
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
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
        del.setOnAction(new EventHandler<ActionEvent>() {
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
          flush.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UserManageView3.employee();
            }
        });




        search.getChildren().addAll(add,del,checkInDatePicker,checkInDatePicker2,fin,textField,findbyusername,back,flush);

        top.getChildren().addAll(search);

        root.setTop(top);

        //分页控件
        Pagination pagination = new Pagination(employeeService.getTotalPage(user), 0);


        pagination.setPageFactory((Integer pageIndex) -> {
            return createPage(pageIndex+1,Costant.PAGE_SIZE, user);
        });

        AnchorPane anchor = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);

        root.setCenter(anchor);
        Scene scene = new Scene(root, 1300, 500, Color.WHITE);

        Startview.setScene(scene);

    }



    public static VBox createPage(Integer currentPage, Integer pageSize,User user) {


        UserService employeeService = new UserServiceImpl();




       //产生数据
        ObservableList<User> data2 =
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

        //编辑
        TableColumn<User, Integer> tableColumn7 = new TableColumn<>("修改");
        // 设置宽度
        tableColumn7.setMinWidth(60);
        // 设置按钮
        tableColumn7.setCellFactory(new Callback<TableColumn<User, Integer>, TableCell<User, Integer>>() {
            @Override
            public TableCell<User, Integer> call(TableColumn<User, Integer> param) {
                Button btn = new Button("修改");

                TableCell<User,Integer> cell = new TableCell<User,Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(actionEvent->{
                                User employee = getTableView().getItems().get(getIndex());
                                UserUpdateView.add(employee);
                                //int id = employee.getId();
                                //EmployeeAddView.add(id);
                            });
                            setGraphic(btn);//设置按钮
                            setText(null);//清空文本
                        }

                    }
                };

                return cell;
            }
        });


        tableView.setItems(data2);

        tableView.getColumns().addAll(
                tableColumn1,
                tableColumn2,
                tableColumn3,
                tableColumn4,
                tableColumn5,
                tableColumn6,
                tableColumn7
        );
        // 设置数据源
        return vBox;
    }



}
