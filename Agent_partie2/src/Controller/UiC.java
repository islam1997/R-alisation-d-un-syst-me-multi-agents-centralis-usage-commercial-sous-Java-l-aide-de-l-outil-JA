package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.FXCollections.*;
import rule.BooleanRuleBase;
import rule.initRuleBase;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class UiC implements Initializable {


    @FXML
    JFXButton Voiture;
    @FXML
    GridPane ze;
    @FXML
    AnchorPane Avoiture;
    @FXML
    BorderPane borderpane;

    //voiture

    @FXML
    ComboBox<String> vehiculeCBox;

    @FXML
    ComboBox<String> vehiculeTypeCbox;

    @FXML
    ComboBox<String> sizeCBox;

    @FXML
    ComboBox<String> motorCBox;

    @FXML
    ComboBox<String> numWheelsCBox;

    @FXML
    ComboBox<String> numDoorsCBox;


    private ContainerController containerController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
try {

        Parent root;
        root = FXMLLoader.load(sample.Main.class.getResource("../View/Ch.fxml"));
        //borderpane.setCenter(null);
        borderpane.setCenter(root);



    } catch (Exception e) {
    System.out.println(e.getMessage());
}









    }

    @FXML
    public void ontech(javafx.event.ActionEvent event) {

        try {
            /*JFXButton b = new JFXButton();
            Parent root;
            root = FXMLLoader.load(sample.Main.class.getResource("../View/Ch.fxml"));
            if (!Avoiture.isVisible())
                Avoiture.setVisible(true);
            /*Node node = root.lookup("#Voiture");
            b=(JFXButton)node;
            Stage stage = new Stage();


            ze.add(b, 0, 3);
            System.out.println("islam");
            */

            Parent root;
            root = FXMLLoader.load(sample.Main.class.getResource("../View/Ch.fxml"));
            //borderpane.setCenter(null);
            borderpane.setCenter(root);


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }











    }

    @FXML
    public void portable(ActionEvent event) {
        //Avoiture.setVisible(false);

        try {
            Parent root;
            root = FXMLLoader.load(sample.Main.class.getResource("../View/Por.fxml"));
            //borderpane.setCenter(null);
            borderpane.setCenter(root);




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void setButton(ActionEvent event) {
    }
}
