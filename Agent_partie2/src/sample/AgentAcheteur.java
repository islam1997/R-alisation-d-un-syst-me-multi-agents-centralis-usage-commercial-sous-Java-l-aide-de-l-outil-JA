package sample;

import Controller.TextController;
import Controller.UiC;
import Controller.VoiC;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import jade.core.behaviours.OneShotBehaviour;
import javafx.stage.Stage;
import rule.BooleanRuleBase;


public class AgentAcheteur extends Agent{

    public String information;
    JFXTextArea textArea;




    @Override
    protected void setup() {
        Object[] arg=getArguments();
        String name=(String)arg[1];
        BooleanRuleBase rb1 = (BooleanRuleBase)arg[0];


        SequentialBehaviour comp=new SequentialBehaviour();

       comp.addSubBehaviour(new OneShotBehaviour(this) {
            @Override
            public void action() {
                ACLMessage aclmsg = new ACLMessage(ACLMessage.INFORM);
                aclmsg.setContent(name);
                aclmsg.addReceiver(new AID("Central", AID.ISLOCALNAME));
                send(aclmsg);


            }
        });

       comp.addSubBehaviour(new OneShotBehaviour() {
           @Override
           public void action() {
               ACLMessage msg = receive();
               while(msg==null)
               {msg = receive();}
                   //Here i want to get the first name of the object Person
                   //System.out.println(msg.getContent());
                   Object[] arg= new Object[0];
                   System.out.println(msg.getContent());
                   information=msg.getContent();
               if (information!=null) {
                   VoiC.data = new Data();
                   VoiC.data.setData(information);


               }


               VoiC.b=0;
               doDelete();
               //System.out.println("islam"+information);




           }


       });



        addBehaviour(comp);










    }

    public void setDisplay(JFXTextArea textArea) {

        this.textArea=textArea;
    }




}
