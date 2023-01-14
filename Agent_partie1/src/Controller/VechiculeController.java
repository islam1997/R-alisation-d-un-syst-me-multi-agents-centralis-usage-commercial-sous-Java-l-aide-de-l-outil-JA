package Controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXComboBox;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class VechiculeController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private ComboBox<String> vehiculeCBox;

    @FXML
    private ComboBox<String> vehiculeTypeCbox;

    @FXML
    private ComboBox<String> sizeCBox;

    @FXML
    private ComboBox<String> motorCBox;

    @FXML
    private ComboBox<String> numWheelsCBox;

    @FXML
    private ComboBox<String> numDoorsCBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StringTokenizer vehiculeToken = new StringTokenizer(
                "Bicycle Tricycle Motorcycle Sports_car Sedan MiniVan Sport_Utility_vehicule null");
        while (vehiculeToken.hasMoreElements()) {
            String nextElement = (String) vehiculeToken.nextElement();
            vehiculeCBox.getItems().add(nextElement);

        }
        StringTokenizer vehiculeTypeToken = new StringTokenizer("cycle automobile null");
        while (vehiculeTypeToken.hasMoreElements()) {
            String nextElement = (String) vehiculeTypeToken.nextElement();
            vehiculeTypeCbox.getItems().add(nextElement);
        }
        StringTokenizer sizeToken = new StringTokenizer("small medium large null");
        while (sizeToken.hasMoreElements()) {
            String nextElement = (String) sizeToken.nextElement();
            sizeCBox.getItems().add(nextElement);
        }

        StringTokenizer motorToken = new StringTokenizer("yes no null");
        while (motorToken.hasMoreElements()) {
            String nextElement = (String) motorToken.nextElement();
            motorCBox.getItems().add(nextElement);
        }
        StringTokenizer numDoorsWheelsToken = new StringTokenizer("2 3 4 null");
        while (numDoorsWheelsToken.hasMoreElements()) {
            String nextElement = (String) numDoorsWheelsToken.nextElement();
            numDoorsCBox.getItems().add(nextElement);
            numWheelsCBox.getItems().add(nextElement);
        }

    }

    @FXML
    void setButton(ActionEvent event) {
        try {
            FileWriter fr = new FileWriter("C:\\Users\\islam\\Downloads\\Expert-system-master\\Agent_partie1\\src\\vehiculeKB.json");
            fr.write("{");

            fr.write("\"vehiculeType\":\"" + ((String) vehiculeTypeCbox.getValue()==null? "null" : (String) vehiculeTypeCbox.getValue()) + "\",");
            fr.write("\"vehicule\":\"" +((String) vehiculeCBox.getValue()==null? "null" : (String) vehiculeCBox.getValue()) + "\",");
            fr.write("\"size\":\"" + ((String) sizeCBox.getValue()==null? "null" : (String) sizeCBox.getValue()) + "\",");
            fr.write("\"motor\":\"" + ((String) motorCBox.getValue()==null? "null" : (String) motorCBox.getValue())  + "\",");
            fr.write("\"num_wheels\":\"" +((String) numWheelsCBox.getValue()==null? "null" : (String) numWheelsCBox.getValue())   + "\",");
            fr.write("\"num_doors\":\"" + ((String) numDoorsCBox.getValue()==null? "null" : (String) numDoorsCBox.getValue()) + "\"");
            fr.write("}");
            fr.close();

        } catch (IOException ex) {
            Logger.getLogger(VechiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
