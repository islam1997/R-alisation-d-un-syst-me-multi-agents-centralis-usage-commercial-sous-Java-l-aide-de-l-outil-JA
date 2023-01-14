package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PortableController implements Initializable {
    @FXML
    public ImageView image;
    @FXML
    public AnchorPane z;
    @FXML
    private Label label;
    @FXML
    private ComboBox<String>MemoireBox;
    @FXML
    private ComboBox<String>PortableCbox;
    @FXML
    private ComboBox<String>SystemeBox;

    @FXML
    private ComboBox<String>CapaciteBox;

    @FXML
    private ComboBox<String> DoubleSimBox;

    @FXML
    private ComboBox<String> WifiBox;

    @FXML
    private ComboBox<String> resolutionbox;

    @FXML
    private ComboBox<String> phtobox;

    @FXML
    private ComboBox<String> flashbox;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        StringTokenizer vehiculeToken = new StringTokenizer(
                "Huawei iphone Samsung LG HTC MI Microsoft null");
        while (vehiculeToken.hasMoreElements()) {
            String nextElement = (String) vehiculeToken.nextElement();
            PortableCbox.getItems().add(nextElement);

        }
        StringTokenizer vehiculeTypeToken = new StringTokenizer("Android IOS Windows_Phone null");
        while (vehiculeTypeToken.hasMoreElements()) {
            String nextElement = (String) vehiculeTypeToken.nextElement();
            SystemeBox.getItems().add(nextElement);
        }
        StringTokenizer sizeToken = new StringTokenizer("32GB 64GB 128GB null");
        while (sizeToken.hasMoreElements()) {
            String nextElement = (String) sizeToken.nextElement();
            CapaciteBox.getItems().add(nextElement);
        }

        StringTokenizer motorToken = new StringTokenizer("4gb 3gb 2gb 1gb null");
        while (motorToken.hasMoreElements()) {
            String nextElement = (String) motorToken.nextElement();
            MemoireBox.getItems().add(nextElement);
        }
        StringTokenizer numDoorsWheelsToken = new StringTokenizer("yes no null");
        while (numDoorsWheelsToken.hasMoreElements()) {
            String nextElement = (String) numDoorsWheelsToken.nextElement();
            WifiBox.getItems().add(nextElement);
        }

        StringTokenizer numDoorsWheelsToken2 = new StringTokenizer("8MPX 12MPX 15MPX 20MPX null");
        while (numDoorsWheelsToken2.hasMoreElements()) {
            String nextElement = (String) numDoorsWheelsToken2.nextElement();
            phtobox.getItems().add(nextElement);
        }

        StringTokenizer numDoorsWheelsToken3 = new StringTokenizer("yes no null");
        while (numDoorsWheelsToken3.hasMoreElements()) {
            String nextElement = (String) numDoorsWheelsToken3.nextElement();
            flashbox.getItems().add(nextElement);
        }

        StringTokenizer numDoorsWheelsToken4 = new StringTokenizer("SD HD FULL_HD null");
        while (numDoorsWheelsToken4.hasMoreElements()) {
            String nextElement = (String) numDoorsWheelsToken4.nextElement();
            resolutionbox.getItems().add(nextElement);
        }

        StringTokenizer numDoorsWheelsToken5 = new StringTokenizer("yes no null");
        while (numDoorsWheelsToken5.hasMoreElements()) {
            String nextElement = (String) numDoorsWheelsToken5.nextElement();
            DoubleSimBox.getItems().add(nextElement);
        }
    }
    @FXML
    void setButton(ActionEvent event) {
        try {
            FileWriter fr = new FileWriter("C:\\Users\\islam\\Downloads\\Expert-system-master\\Agent_partie1\\src\\PotablesKB.json");
            fr.write("{");
                 System.out.println(PortableCbox.getValue());
            fr.write("\"portables\":\"" + ((String) PortableCbox.getValue()==null? "null" : (String) PortableCbox.getValue()) + "\",");
            fr.write("\"systeme\":\"" +((String) SystemeBox.getValue()==null? "null" : (String) SystemeBox.getValue()) + "\",");
            fr.write("\"capacite\":\"" + ((String) CapaciteBox.getValue()==null? "null" : (String) CapaciteBox.getValue()) + "\",");
            fr.write("\"memoire\":\"" + ((String)  MemoireBox.getValue()==null? "null" : (String) MemoireBox.getValue())  + "\",");
            fr.write("\"double_Sim\":\"" + ((String)  DoubleSimBox.getValue()==null? "null" : (String)  DoubleSimBox.getValue()) + "\",");
            fr.write("\"wifi\":\"" +((String) WifiBox.getValue()==null? "null" : (String) WifiBox.getValue())   + "\",");
            fr.write("\"resolution\":\"" + ((String) resolutionbox.getValue()==null? "null" : (String) resolutionbox.getValue()) + "\",");
            fr.write("\"capture_photo\":\"" + ((String) phtobox.getValue()==null? "null" : (String) phtobox.getValue()) + "\",");
            fr.write("\"flash\":\"" + ((String) flashbox.getValue()==null? "null" : (String) flashbox.getValue()) + "\"");



            fr.write("}");
            fr.close();
            Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();

        } catch (IOException ex) {
            Logger.getLogger(VechiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
