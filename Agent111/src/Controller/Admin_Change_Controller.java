package Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import rule.*;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Admin_Change_Controller implements Initializable {


    @FXML
    public JFXTextField consc2;
    @FXML
    public JFXTextField consc1;
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
    private Rule rule;

    public ArrayList<Clause> clauses=new ArrayList<>();



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

        TreeItem<Model> root=new RecursiveTreeItem<Model>(list, RecursiveTreeObject::getChildren);
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


       /* treeTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            showDetails(newValue);
        });*/

    }

    public  void  showDetails(TreeItem<Model> treeItem){



        genderCombo.getSelectionModel().select(treeItem.getValue().getcause1());




    }

    public void information(Rule rules)
    {
          rule=rules;
          rules.copie();
          for (int j=0;j<rules.antecedents3.size();j++)
             list.addAll(new Model(rules.antecedents3.get(j).lhs.getName(),rules.antecedents3.get(j).cond.toString(),rules.antecedents3.get(j).rhs));
             consc1.setText(rules.concequent.lhs.getName());
             consc2.setText(rules.concequent.rhs);
             rulec.setText(rules.getname());


    }
    @FXML
    public void addAction(ActionEvent event) {
        for (int i=0;i<MainApplicationController.rb.rules.size();i++) {
            if (rule.getname() == MainApplicationController.rb.rules.get(i).getname()) {
                MainApplicationController.rb.rules.get(i).Setname(rulec.getText());

                clauses=MainApplicationController.rb.rules.get(i).antecedents3;
                for (int j=0;j<clauses.size();j++)
                {
                    TreeItem<Model> mod=treeTableView.getTreeItem(j);
                    Model mod2=mod.getValue();
                   /* clauses.get(i).rhs=mod2.getcause3();
                    System.out.println(clauses.get(i).rhs);
                    clauses.get(i).lhs.SetName(mod2.getcause1());
                    System.out.println(clauses.get(i).lhs.getName());
                    clauses.get(i).cond.setsymbole(mod2.getcause2());
                    System.out.println(clauses.get(i).cond.toString());*/
                    MainApplicationController.rb.rules.get(i).update3(mod2.getcause1(),mod2.getcause2(),mod2.getcause3(),j);

                }
                //MainApplicationController.rb.rules.get(i).update2(clauses);

                MainApplicationController.rb.rules.get(i).concequent.lhs.SetName(consc1.getText());
                MainApplicationController.rb.rules.get(i).concequent.rhs=consc2.getText();
                MainApplicationController.rb.rules.get(i).name=rulec.getText();
                MainApplicationController.rb.ruleList.set(i,MainApplicationController.rb.rules.get(i));
                break;

            }
        }

    }
    @FXML
    public void deleteAction(ActionEvent event) {
        Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();

    }
    @FXML
    public void editAction(ActionEvent event) {
        TreeItem <Model> treeItem=treeTableView.getSelectionModel().getSelectedItem();
        Model m=new Model(genderCombo.getSelectionModel().getSelectedItem(),genderCombo1.getSelectionModel().getSelectedItem(),ageTF.getText());
        treeItem.setValue(m);

    }
}
