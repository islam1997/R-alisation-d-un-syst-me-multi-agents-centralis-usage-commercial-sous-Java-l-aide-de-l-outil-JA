package Controller;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;
import rule.Model;
import rule.Rule;
import rule.RuleVariable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Admin implements Initializable {

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

        Cause1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Model, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Model, String> param) {
                return param.getValue().getValue().cause1;
            }
        });




        list= FXCollections.observableArrayList();

        TreeItem<Model> root=new RecursiveTreeItem<Model>(list, RecursiveTreeObject::getChildren);
        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);
        System.out.println(MainApplicationController.rb.rules.size());
        for (int i=0;i<MainApplicationController.rb.rules.size();i++)
        {

            list.addAll(new Model(MainApplicationController.rb.rules.get(i).getname()));
        }



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

    public void addAction(ActionEvent event) {
        try {
            Parent root;
            //root = FXMLLoader.load(sample.Main.class.getResource("../View/sample2.fxml"));
            root = FXMLLoader.load(sample.Main.class.getResource("../View/sample2.fxml"));

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
    public void deleteAction(ActionEvent event) {
        int index=treeTableView.getSelectionModel().getSelectedIndex();
        System.out.println(index);


        for (int i=0;i<MainApplicationController.rb.rules.size();i++)
        {
            if (list.get(index).getcause1()==MainApplicationController.rb.rules.get(i).getname())
            {
               System.out.println("1"+list.get(index).getcause1());
                System.out.println("2"+MainApplicationController.rb.rules.get(i).getname());
                System.out.println("3"+MainApplicationController.rb.ruleList.get(i).toString());
                MainApplicationController.rb.rules.remove(i);
                MainApplicationController.rb.ruleList.remove(i);
                break;
            }



        }
        list.remove(index);

    }

    public void editAction(ActionEvent event) {
        try {
            Parent root;
            //root = FXMLLoader.load(sample.Main.class.getResource("../View/Info.fxml"));
            FXMLLoader loader = new FXMLLoader(sample.Main.class.getResource("../View/Admin_change.fxml"));
            root = loader.load();
            Admin_Change_Controller scene2Controller = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Information");
            JFXDecorator decorator = new JFXDecorator(stage,root);

            stage.setScene(new Scene(decorator));
            stage.setResizable(false);
            stage.show();
            int index=treeTableView.getSelectionModel().getSelectedIndex();
            

            Rule rule = null;
            for (int i=0;i<MainApplicationController.rb.rules.size();i++) {
                if (list.get(index).getcause1() == MainApplicationController.rb.rules.get(i).getname()) {
                    rule = MainApplicationController.rb.rules.get(i);
                    break;
                }
            }
                scene2Controller.information(rule);
            

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void clearAction(ActionEvent event) {
        Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();

    }
}
