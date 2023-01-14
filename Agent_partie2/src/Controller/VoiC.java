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
import javafx.stage.Stage;
import rule.BooleanRuleBase;
import rule.initRuleBase;
import sample.AgentAcheteur;
import sample.Data;
import sample.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VoiC implements Initializable {
    static public int b;
    static public String s;
    static public Data data;

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


    @FXML
    public void setButton(ActionEvent event) {
        b=1;
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
        ArrayList<String> values=new ArrayList<>();
        values.add(vehiculeTypeCbox.getValue());
        values.add(vehiculeCBox.getValue());
        values.add(sizeCBox.getValue());
        values.add(motorCBox.getValue());
        values.add(numWheelsCBox.getValue());
        values.add(numDoorsCBox.getValue());


        while (b==1){System.out.print("");}
        try {
            Parent root;
            //root = FXMLLoader.load(sample.Main.class.getResource("../View/Info.fxml"));
            FXMLLoader loader = new FXMLLoader(sample.Main.class.getResource("../View/Voiture_disp.fxml"));
            root = loader.load();
            TextController scene2Controller = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Information");
            JFXDecorator decorator = new JFXDecorator(stage,root);
            scene2Controller.setvalue(values);
            stage.setScene(new Scene(decorator));
            stage.setResizable(false);
            stage.show();
            scene2Controller.transferMessage(data.toString());
            b=1;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }



    }


    public void setButton2(ActionEvent event) {
    }
}
