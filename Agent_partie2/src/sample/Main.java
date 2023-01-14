package sample;

import Controller.UiC;
import com.jfoenix.controls.JFXDecorator;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rule.BooleanRuleBase;
import rule.initRuleBase;

public class Main extends Application {
    Stage stageApp;
   public static ContainerController mc;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stageApp = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        UiC uic=new UiC();

        Scene scene = new Scene(root);

        stageApp.setScene(scene);
        stageApp.setResizable(false);
        stageApp.show();
        Object[] arg1 = new Object[2];
        Object[] arg2 = new Object[2];
        Object[] arg3 = new Object[2];

        BooleanRuleBase rb1 = new BooleanRuleBase("vehicule");
        BooleanRuleBase rb2 = new BooleanRuleBase("Protable");
        initRuleBase.initVehiculeRuleBase(rb1);
        initRuleBase.initProtableRuleBase(rb2);
        try{
            Runtime rt = Runtime.instance();
            ProfileImpl p = new ProfileImpl("localhost", 1099, "RSHP", false);
          mc = rt.createMainContainer(p);
            AgentController rma = mc.createNewAgent("rma", "jade.tools.rma.rma"
                    ,null);
            p.setParameter("gui",null);
            arg1[0] = rb1;
            arg1[1] = "Vehicule";

            AgentController ag1 = mc.createNewAgent("Vendeur1",
                    "sample.Vendeur1", arg1);
            arg2[0] = rb2;
            arg2[1] = "Protable";

            AgentController ag2 = mc.createNewAgent("Vendeur2",
                    "sample.Vendeur2" , arg2);





            arg3[0] = rb1;
            arg3[1] = "vehicle";
            AgentController ag3 = mc.createNewAgent("Central",
                    "sample.CentralAgent",arg3);





            rma.start();
            ag1.start();
            ag2.start();
            ag3.start();



        } catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
