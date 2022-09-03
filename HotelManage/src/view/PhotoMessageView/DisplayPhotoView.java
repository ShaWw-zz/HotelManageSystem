package view.PhotoMessageView;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import service.PhotoService;
import service.impl.PhotoServiceImpl;

import java.io.File;

public class DisplayPhotoView {
    public  static void start()  {
        Stage stage=new Stage();
        //HBox hBox=new HBox(10);
        //javafx.scene.layout.Pane pane=hBox;
        FlowPane Pane=new FlowPane();
        Pane.setHgap(10);
        Pane.setVgap(10);
        Pane.setPadding(new Insets(10,10,10,10));

        Scene scene2 = new Scene(Pane,700,500);
        File f = new File("D:\\Java-project\\photo\\1.jpg");

        Image image= new Image(f.toURI().toString(),100,100,false, false);
        //ImageView imv = new ImageView(image);

        /*Image image = new Image("https://img-blog.csdnimg.cn/20190125135919960.png");
        pane.getChildren().add(new ImageView(image));

        ImageView imageview2 = new ImageView(image);
        imageview2.setFitHeight(30);
        imageview2.setFitWidth(30);
        pane.getChildren().add(imageview2);

        ImageView imageview3 = new ImageView(image);
        //imageview3.setRotate(90);
        pane.getChildren().add(imageview3);*/
        //加入背景图
        Pane.setStyle("-fx-background-image: url(images/photobeijing.jpg); -fx-background-repeat: no-repeat;/*-fx-background-size: 700 600;*/ -fx-background-position: center center;");

        PhotoService service=new PhotoServiceImpl();

        for (String s:service.findAllpath()
             ) {
            File f2 = new File(s);
            Image image1= new Image(f2.toURI().toString(),150,150,false, false);
            Pane.getChildren().add(new ImageView(image1));

        }



        Stage stage2 = new Stage();
        stage2.setTitle("照片墙");
        stage2.setScene(scene2);

        stage2.setResizable(false);
        stage2.show();


    }


}
