package sample;

import Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    Stage stageApp;
    @Override
    public void start(Stage stage) throws Exception{
        this.stageApp = stage;
        Parent root = FXMLLoader.load(getClass().getResource("../View/MainView.fxml"));


        Scene scene = new Scene(root, 570, 400);

        stageApp.setScene(scene);
        stageApp.setResizable(false);
        stageApp.show();
    }













    public static void main(String[] args) {
        launch(args);
    }

}