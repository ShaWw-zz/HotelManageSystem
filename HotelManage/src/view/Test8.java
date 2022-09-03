package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test8 extends Application {
    private Pagination pagination;//分页组件的定义
    String[] fonts = new String[]{};//展示的文本内容的定义

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public int itemsPerPage() {//每页展示固定的15行
        return 15;
    }

    public VBox createPage(int pageIndex) {
        VBox box = new VBox(5);//创建一个垂直布局盒子对象间隙距离为5
        int page = pageIndex * itemsPerPage();//页码号*当页条目数量=当前条目起始索引位置
        for (int i = page; i < page + itemsPerPage(); i++) {//循环构建渲染出要展示的条目组件
            TextField font = new TextField(fonts[i]);//创建一个文本框组件
            box.getChildren().add(font);//垂直盒子布局对象中添加要显示的内容本例中添加的是文本框组件
        }
        return box;
    }

    @Override
    public void start(final Stage stage) throws Exception {
        fonts = Font.getFamilies().toArray(fonts);//获得系统字体数组并将名称内容赋值给前文定义的String[] fonts
        pagination = new Pagination(fonts.length/itemsPerPage(), 0);//通过数据条目算出总页数
        pagination.setStyle("-fx-border-color:red;");//给分页组件添加 css样式
        pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex));//给分页组件挂载待展示显示的内容工厂方法
        AnchorPane anchor = new AnchorPane();//创建锚点面板
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);//在锚点面板上添加分页组件
        Scene scene = new Scene(anchor, 400, 450);//创建场景对象
        stage.setScene(scene);//舞台上创建场景对象
        stage.setTitle("场景上添加标题");
        stage.show();//舞台展现
    }
}

