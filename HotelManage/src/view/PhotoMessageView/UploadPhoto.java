package view.PhotoMessageView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.PhotoService;
import service.impl.PhotoServiceImpl;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class UploadPhoto  {



    public static void start(String username,String password) {


        /*新建一个网格面板
         * */
        final TextField gN = new TextField();
        final TextField gP = new TextField();
        final TextField gK = new TextField();
        final TextField LJ = new TextField();
        final Label labelgN = new Label("用户名：");
        final Label labelgP = new Label("密码：");

        //final Label labelgK = new Label("房间类型：");
        final Label P_Lj = new Label("图片路径：");
        final Label labelsC = new Label("上传照片：");
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        gN.setPromptText("输入用户名:"+username);
        gP.setPromptText("输入密码"+password);
        //gK.setPromptText("输入商品类型");
        LJ.setPromptText("图片路径");


        Stage stage = new Stage();
        GridPane rootGP = new GridPane();
        rootGP.setStyle("-fx-background-image: url(images/R—2.jpg); -fx-background-repeat: no-repeat;/*-fx-background-size: 800 600*/; -fx-background-position: center center;");
        rootGP.setAlignment(Pos.CENTER);
        rootGP.setHgap(10);
        rootGP.setVgap(10);
        rootGP.setPadding(new Insets(10, 10, 10, 10));

        rootGP.add(labelgN, 0, 0);
        rootGP.add(labelgP, 0, 2);
       // rootGP.add(labelgK, 0, 4);
        rootGP.add(gN, 1, 0);
        rootGP.add(gP, 1, 2);
        //rootGP.add(gK, 1, 4);
        rootGP.add(LJ, 1, 5);
        rootGP.add(P_Lj, 0, 5);
        rootGP.add(labelsC, 0, 6);

        Button TJ = new Button("添加");
        Button CZ = new Button("重置");
        Button sC = new Button("上传照片");
        rootGP.add(sC,2,9);
        rootGP.add(CZ,0,9);
        rootGP.add(TJ,1,9);
        rootGP.setMargin(TJ,new Insets(0,0,0,70));

        /*重置操作*/
        CZ.setOnAction(e -> {
            UploadPhoto.start(username,password);
            stage.close();
        });

        /*关闭窗口*/

        sC.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           /*上传本地*/
                           public void handle(ActionEvent event) {
                               Stage stage=new Stage();
                               FileChooser fc=new FileChooser();
                               final String[] a = {new String()};

                               fc.setTitle("上传图片");
                               fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("图片类型","*.jpg","*.png","*.jpeg"));
                               fc.setInitialDirectory(new File("D:\\java-project\\photo"));   //文件目录
                               List<File> list=fc.showOpenMultipleDialog(stage);
                               list.forEach(new Consumer<File>() {
                                   @Override
                                   public void accept(File file) {
                                       a[0] = file.getAbsolutePath();
                                       System.out.println(a[0]);
                                       final ImageView imageView = new ImageView(
                                               new Image("file:\\"+a[0],200,200,false,false)
                                       );
                                       System.out.println("file:\\"+a[0]);
                                       final Button tp=new Button("",imageView);
                                       rootGP.add(tp,2,7);
                                   }
                               });
                               LJ.setText(a[0]);
                               //fc.showOpenDialog(stage);

                           }
                       }
        );

        TJ.setOnAction(e -> {
            PhotoService service=new PhotoServiceImpl();
            /*String uuid = UUID.randomUUID().toString();
            String inputFile = LJ.getText();
            String realPath = "d:\\temp\\";*/

            /*try {
                InputStream in = new FileInputStream(inputFile);
                OutputStream out = new FileOutputStream(realPath+uuid);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }*/

            service.add(LJ.getText(),username,password);
            //stage.close();

        });

        Scene scene=new Scene(rootGP,500,700);
        stage.setScene(scene);
        stage.show();

    }
}
