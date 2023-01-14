/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import com.jfoenix.controls.JFXTextArea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Hassaine
 */
public class Rule {
    BooleanRuleBase rb;
    String name;
    public Clause[] antecedents;
    Clause concequent;
    Boolean truth;
    ArrayList<Clause> antecedents2;

    public ArrayList<Clause> antecedents3=new ArrayList<>();
    public boolean fired=false;

    public void copie()
    {
        for (int i=0;i<antecedents.length;i++)
            antecedents3.add(antecedents[i]);
    }
    public Rule(BooleanRuleBase rb, String name, Clause lhs, Clause rhs) {
        this.rb = rb;
        this.name = name;
        this.antecedents= new Clause[1];
        this.antecedents[0] = lhs;
        lhs.addRuleRef(this);
        this.concequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConcequent();
        rb.ruleList.add(this);
        rb.rules.add(this);
        this.truth = null;
    }
    public String getname(){return this.name;}
    public void Setname(String name){this.name=name;}
    public Rule(BooleanRuleBase rb, String name, Clause[] lhs, Clause rhs) {
        this.rb = rb;
        this.name = name;
        this.antecedents= new Clause[lhs.length];
        for (int i = 0; i < lhs.length; i++) {
            this.antecedents[i] = lhs[i];
            lhs[i].addRuleRef(this);

        }




        this.concequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConcequent();
        rb.ruleList.addElement(this);
        rb.rules.add(this);
        this.truth = null;
    }
    public Rule(BooleanRuleBase rb, String name,Clause rhs)
    {
        this.rb=rb;
        this.name=name;
        antecedents2=new ArrayList<>();
        this.concequent = rhs;
        rhs.addRuleRef(this);
        rhs.setConcequent();
        rb.ruleList.add(this);
        rb.rules.add(this);
        this.truth = null;
    }
    public void add_clause(Clause clause)
    {
        antecedents2.add(clause);
    }
    public void update2(ArrayList<Clause> cl)
    {this.antecedents=null;
        this.antecedents=new Clause[cl.size()];
        System.out.println(cl.size());
        for (int i=0;i<cl.size();i++) {
            antecedents[i] = cl.get(i);
            System.out.println("1"+cl.get(i).lhs.getName()+cl.get(i).cond.toString()+cl.get(i).rhs);
            System.out.println(antecedents[i].lhs.getName()+antecedents[i].cond.toString()+antecedents[i].rhs);
        }
    }


    public void update_clause()
    {
        Clause ante[]=new Clause[antecedents2.size()+antecedents.length];
        int i;
        for (i=0;i<ante.length;i++)
            ante[i]=antecedents[i];
        int j;
        for (j=i;j<ante.length;j++)
            ante[j]=antecedents2.get(j);
        antecedents=ante;

    }


    public Boolean check() {
        for (int i = 0; i <antecedents.length; i++) {
            if(antecedents[i].truth==null){

                return truth=null;
               
            }
            if(antecedents[i].truth.booleanValue()==false){

               return truth= new Boolean(false);

            }
            
        }
        System.out.println("a3");
        return truth= new Boolean(true);
    }

    public long numAntecedents() {
        return antecedents.length;
    }
    public void fire(){
        rb.trace("\nFiring Rule"+name);
        truth= new Boolean(true);
        fired=true;
        if(concequent.lhs==null){
         //   ((EffectorClause) concequent).perform(rb);
        }else{
            concequent.lhs.setValue(concequent.rhs);
            checkRules(concequent.lhs.clauseRefs);
        }
    }

    public static void checkRules(Vector clauseRefs) {
        Enumeration elements = clauseRefs.elements();
        while(elements.hasMoreElements()){
            Clause temp = (Clause) elements.nextElement();
            Enumeration elements_2 = temp.ruleRefs.elements();
            while(elements_2.hasMoreElements()){
                ((Rule) elements_2.nextElement()).check();
            }
        }
       
    }
    public void display(JFXTextArea JFXtextArea){
        System.out.println(name+": IF");
            JFXtextArea.appendText(name+":\n IF ");
            for (int i = 0; i < antecedents.length; i++) {
                Clause nextClause = antecedents[i];
                System.out.println(nextClause.toString());
                JFXtextArea.appendText(nextClause.toString());
                if(i+1<antecedents.length){
                    System.out.println("\n     AND ");
                     JFXtextArea.appendText("\n     AND ");
                }

        }
            System.out.println("\n     THEN ");
            System.out.println(concequent.toString());
            JFXtextArea.appendText("\n     THEN ");
             JFXtextArea.appendText(concequent.toString()+"\n");

    }


    public void display2(StringBuilder JFXtextArea){
        System.out.println(name+": IF");
        JFXtextArea.append(name+":\n IF ");
        for (int i = 0; i < antecedents.length; i++) {
            Clause nextClause = antecedents[i];
            System.out.println(nextClause.toString());
            JFXtextArea.append(nextClause.toString());
            if(i+1<antecedents.length){
                System.out.println("\n     AND ");
                JFXtextArea.append("\n     AND ");
            }

        }
        System.out.println("\n     THEN ");
        System.out.println(concequent.toString());
        JFXtextArea.append("\n     THEN ");
        JFXtextArea.append(concequent.toString()+"\n");

    }

    
    
}
