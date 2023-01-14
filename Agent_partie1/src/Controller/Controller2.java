package Controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import rule.Model;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;
//import org.omg.CORBA.INITIALIZE;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import rule.RuleVariable;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Controller2 implements Initializable{


    @FXML
    private TreeTableColumn<Model, String> Cause1;

    @FXML
    private TreeTableColumn<Model, String> Cause2;

    @FXML
    private TreeTableColumn<Model, String> Cause3;


    static public String copie;
    @FXML
    private JFXTreeTableView<Model> treeTableView;

    @FXML
    private JFXComboBox<String> genderCombo;

    @FXML
    private JFXComboBox<String> genderCombo1;
    @FXML
    private JFXTextField rulec;



    @FXML
    private JFXTextField ageTF;
    @FXML
    private TextArea zzz;


    ObservableList<Model> list;
    int choice;
    static public ArrayList<RuleVariable> rulevar;
    static public ArrayList<String> item1,item2;
    static public String namerule;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice=0;
      rulevar=new ArrayList<>();
      item1=new ArrayList<>();
        item2=new ArrayList<>();
         for (int i=0;i<MainApplicationController.rb.VariableName.size();i++) {
             genderCombo.getItems().add(MainApplicationController.rb.VariableName.get(i));

         }
        genderCombo1.getItems().addAll("=",">","<","<=",">=");



        Cause1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().cause1;
            }
        });


        Cause2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().cause2;
            }
        });


        Cause3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().cause3;
            }
        });


        list= FXCollections.observableArrayList();

        TreeItem<Model> root=new RecursiveTreeItem<Model>(list, RecursiveTreeObject ::getChildren);
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);



       /* searchTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                treeTableView.setPredicate(new Predicate<TreeItem<Model>>() {
                    @Override
                    public boolean test(TreeItem<Model> modelTreeItem) {
                        return modelTreeItem.getValue().name.getValue().contains(newValue) |modelTreeItem.getValue().age.getValue().contains(newValue) ;
                    }
                });
            }
        });*/


        treeTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            showDetails(newValue);
        });

    }


    @FXML
    void  addAction(ActionEvent event){
  if (genderCombo.getValue()==null || genderCombo1.getValue()==null || ageTF.getText()=="" || rulec.getText()=="") {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Information Dialog");
      alert.setHeaderText("Il y'a des cases Vide");
      //alert.setContentText("Il faut remplir les cases\nRemarque: pour les antecedents chaque\n ligne represente un antecedent ");

      System.out.println("islam");
      alert.showAndWait();
  }else {
      if (choice == 0) {
          choice++;
          zzz.appendText(rulec.getText() + ":\n IF ");
          namerule=rulec.getText();
          zzz.appendText(genderCombo.getValue() + " " + genderCombo1.getValue() + " " + ageTF.getText());

      } else {
          zzz.appendText("\n     AND ");
          zzz.appendText(":\n IF ");
          zzz.appendText(genderCombo.getValue() + " " + genderCombo1.getValue() + " " + ageTF.getText());

      }
      item1.add(genderCombo1.getValue());
      item1.add(ageTF.getText());
      for (int i=0;i<MainApplicationController.rb.variable.size();i++)
      {
          if (MainApplicationController.rb.variable.get(i).getName().equals(genderCombo.getValue())) {
              rulevar.add(MainApplicationController.rb.variable.get(i));
              System.out.println(MainApplicationController.rb.variable.get(i).getName());
              break;
          }
      }

      list.addAll(new Model(genderCombo.getValue(), genderCombo1.getValue(), ageTF.getText()));

  }

    }


    @FXML
    void  deleteAction(ActionEvent event){
        int index=treeTableView.getSelectionModel().getSelectedIndex();
        list.remove(index);
        clearFields();
    }

    public  void  showDetails(TreeItem<Model> treeItem){

        ageTF.setText(treeItem.getValue().getcause3());

        genderCombo.getSelectionModel().select(treeItem.getValue().getcause1());
        genderCombo1.getSelectionModel().select(treeItem.getValue().getcause2());


    }


    public void clearFields(){

        ageTF.setText("");

        genderCombo.getSelectionModel().select("");
    }

    @FXML
    void clearAction(ActionEvent event)
    {
        try {
            copie=zzz.getText();
            Parent root;
            root = FXMLLoader.load(Main.class.getResource("../View/Add_Rule.fxml"));

            Stage stage = new Stage();
            stage.setTitle("Add_Rule");
            JFXDecorator decorator = new JFXDecorator(stage,root);

            stage.setScene(new Scene(decorator));
            stage.setResizable(false);
            stage.show();


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }



    @FXML
    void editAction(ActionEvent event){

        TreeItem <Model> treeItem=treeTableView.getSelectionModel().getSelectedItem();

        //Model m=new Model(nameTF.getText(),jobTF.getText(),ageTF.getText(),genderCombo.getSelectionModel().getSelectedItem());

        //treeItem.setValue(m);

    }

}
