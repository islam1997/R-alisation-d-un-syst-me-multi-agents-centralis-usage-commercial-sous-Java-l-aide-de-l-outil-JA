package Controller;

import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextArea;
import jade.wrapper.AgentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import rule.BooleanRuleBase;
import rule.initRuleBase;
import sample.AgentAcheteur;
import sample.Main;
import sample.Vendeur1;

import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;


public class TextController implements Initializable {

    static public String text;
    @FXML
    public TextArea info;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {


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


    public void setvalue(ArrayList<String> s)
    {
        vehiculeTypeCbox.setValue(s.get(0));
        vehiculeCBox.setValue(s.get(1));
        sizeCBox.setValue(s.get(2));
        motorCBox.setValue(s.get(3));
        numWheelsCBox.setValue(s.get(4));
        numDoorsCBox.setValue(s.get(5));


    }

    public void action(ActionEvent event) {
        Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();

    }

    //Receive message from scene 1
    public void transferMessage(String message) {
        //Display the message
        info.setText(message);
    }
   @FXML
    public void setButton(ActionEvent event) {

       VoiC.b=1;
       Object[] arg3 = new Object[2];
       BooleanRuleBase rb1 = new BooleanRuleBase("vehicule");
       //BooleanRuleBase rb2 = new BooleanRuleBase("Protable");
       initRuleBase.initVehiculeRuleBase(rb1);
       //initRuleBase.initProtableRuleBase(rb2);

       try{
           arg3[0] = rb1;
           arg3[1] = "vehicule";

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


           AgentController ag5 = Main.mc.createNewAgent("AgentAcheteur",
                   "sample.AgentAcheteur",arg3);
           ag5.start();






       } catch (Exception e){
           e.printStackTrace();
       }



       while (VoiC.b==1){System.out.print("");}
       VoiC.b=1;
       info.appendText(VoiC.data.toString());

    }
    @FXML
    public void setButton2(ActionEvent event) {

        Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
