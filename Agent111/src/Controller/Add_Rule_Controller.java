package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import rule.Clause;
import rule.Condition;
import rule.Rule;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Add_Rule_Controller  implements Initializable {

    @FXML
    ComboBox<String> rulec_id;

    @FXML
    ComboBox<String> rulec_id1;

    @FXML
    TextArea anttext;
    @FXML
    TextField resultat;
    @FXML
    TextArea clause3;


    int time;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
           time=0;
           anttext.setText(Controller2.copie);
        //Vector<String> var=new Vector<>(MainApplicationController.rb.variable.get(i));

           for (int i=0;i<MainApplicationController.rb.variable.size();i++)
           rulec_id.getItems().add(MainApplicationController.rb.variable.get(i).getName());
        rulec_id1.getItems().addAll("=",">","<","<=",">=");
        }


    @FXML
    void Annuler(ActionEvent event)
    {
        try {
            Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void Ajouter(ActionEvent event)
    {
        try {
            if (rulec_id.getValue()==null)
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Il y'a des cases Vide");
            }else
            {
                for (int i=0;i<MainApplicationController.rb.variable.size();i++)
                {

                    if (MainApplicationController.rb.variable.get(i).getName().equals(rulec_id.getValue())) {
                        System.out.println(Controller2.namerule);

                        Rule rule=new Rule(MainApplicationController.rb,
                                Controller2.namerule,new Clause(MainApplicationController.rb.variable.get(i),new Condition(rulec_id1.getValue()),resultat.getText()));
                        for (int j=0;j<Controller2.rulevar.size();j++)
                        {
                          rule.add_clause(new Clause(Controller2.rulevar.get(j),new Condition(Controller2.item1.get(j)),Controller2.item2.get(j)));
                        }
                        rule.update_clause();
                        break;
                    }
                }

                //
            }
           /* String[] lines = anttext.getText().split(System.getProperty("line.separator"));
            String[] lines2 = clause2.getText().split(System.getProperty("line.separator"));
            String[] lines3 = clause3.getText().split(System.getProperty("line.separator"));
            if (cotext.getText().equals("") || anttext.getText()==""||
                    lines.length!=lines2.length || lines.length!=lines3.length) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Consequence\\antecedents Vide");
                alert.setContentText("Il faut remplir les cases\nRemarque: pour les antecedents chaque\n ligne represente un antecedent ");

                System.out.println("islam" );
                alert.showAndWait();
            }else
            {
                Condition cEquals = new Condition("=");
                Condition cNotEquals = new Condition("!=");
                Condition clessThen = new Condition("<");
                Condition cMoreThen = new Condition(">");

              /*  Rule iphone = new Rule(MainApplicationController.rb, "Iphone",
                        new Clause[]{new Clause(RAm, cEquals, "3GB"),
                                new Clause(Capacite, cEquals, "128gb")
                                ,new Clause(resolution_decran,cEquals,"FULL_HD"),new Clause(systeme,cEquals,"IOS"), new Clause(WiFi, cEquals, "yes")},
                        new Clause(Portables, cEquals, "Iphone"));*/
              //Rule newrule=new Rule(MainApplicationController.rb,cotext.getText(),
                    //new Clause(MainApplicationController.rb,cEquals,cotext.getText()));

           // Rule=new Rule((MainApplicationController.rb,cotext.getText(),li))

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void Show(ActionEvent event)
    {
        anttext.setText(Controller2.copie+"\n    THEN"+rulec_id.getValue()+" "+rulec_id1.getValue()+" "+resultat.getText());
    }
}
