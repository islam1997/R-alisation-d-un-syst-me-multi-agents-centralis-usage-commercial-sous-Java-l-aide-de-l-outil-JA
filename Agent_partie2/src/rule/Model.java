package rule;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by mohamed on 7/10/2017.
 */
public class Model extends RecursiveTreeObject<Model> {


    public StringProperty cause1 , cause2 ,cause3;

    public Model( String cause1 ,String cause2 ,String cause3 ){

        this.cause1=new SimpleStringProperty(cause1);
        this.cause2=new SimpleStringProperty(cause2);
        this.cause3=new SimpleStringProperty(cause3);

    }


    public String getcause1() {
        return cause1.get();
    }

    public StringProperty cause1Property() {
        return cause1;
    }

    public void setcause1(String cause1) {
        this.cause1.set(cause1);
    }

    public String getcause2() {
        return cause2.get();
    }

    public StringProperty cause2Property() {
        return cause2;
    }

    public void setcause2(String cause2) {
        this.cause2.set(cause2);
    }

    public String getcause3() {
        return cause3.get();
    }

    public StringProperty cause3Property() {
        return cause3;
    }

    public void setcause3(String cause3) {
        this.cause3.set(cause3);
    }
}
