package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.Timeline;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Timeline timeline=new Timeline();
        //timeline.setCycleCount(Timeline.INDEFINITE);
        //timeline.setAutoReverse(false);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("葫芦娃");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
