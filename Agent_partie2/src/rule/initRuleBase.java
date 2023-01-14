/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rule;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;


public class initRuleBase {

    public static void initProtableRuleBase(BooleanRuleBase rb) {

        System.out.println(rb.name);
        // rule Variable
        RuleVariable Portables = new RuleVariable(rb, "portables");
        Portables.setLabels(
                "Huawei Apple Samsung LG HTC MI Microsoft ");
        Portables.setPromptText("PORTABLE?");

        RuleVariable systeme = new RuleVariable(rb, "systeme");
        systeme.setLabels("Android IOS Windows_Phone");
        RuleVariable RAm = new RuleVariable(rb, "memoire");
        RAm.setLabels("4gb 3gb 2gb 1gb");
        RAm.setPromptText("RAM?");

        RuleVariable Capacite = new RuleVariable(rb, "capacite");
        Capacite.setLabels("32GB 64GB 128GB");
        Capacite.setPromptText("Cpacite?");

        RuleVariable DoubleCartesim = new RuleVariable(rb, "double_Sim");
        DoubleCartesim.setLabels("yes no");
        DoubleCartesim.setPromptText("Doublesim?");



        RuleVariable  WiFi = new RuleVariable(rb, "wifi");
        WiFi.setLabels("yes no");
        WiFi.setPromptText("wifi?");

        RuleVariable Capteur_photo_principal = new RuleVariable(rb,
                "capture_photo");
       Capteur_photo_principal.setLabels("8MPX 12MPX 15MPX 20MPX");
        Capteur_photo_principal.setPromptText("capture?");



        RuleVariable resolution_decran  = new RuleVariable(rb, "resolution");
        resolution_decran.setLabels("SD HD FULL_HD");
        resolution_decran.setPromptText("resolution?");



        RuleVariable Flash = new RuleVariable(rb, "flash");
        Flash.setLabels("yes no");
        Flash.setPromptText("flash?");


        Condition cEquals = new Condition("=");

        Rule Huawei = new Rule(rb, "Huawei",
                new Clause[]{new Clause(RAm, cEquals, "3GB"),
                    new Clause(Capacite, cEquals, "64gb")
                ,new Clause(resolution_decran,cEquals,"HD"),new Clause(systeme,cEquals,"Android")},
                new Clause(Portables, cEquals, "Huawei"));
        Rule HTC = new Rule(rb, "HTC",
                new Clause[]{new Clause(WiFi, cEquals, "no"),
                    new Clause(Capteur_photo_principal, cEquals, "3MPX")},
                new Clause(Portables,cEquals,"HTC"));
        Rule Samsung = new Rule(rb, "Samsung",
                new Clause[]{new Clause(RAm, cEquals, "4GB"),

                        new Clause(Capacite, cEquals, "128gb")
                        ,new Clause(resolution_decran,cEquals,"FULL_HD"),new Clause(systeme,cEquals,"Android"), new Clause(WiFi, cEquals, "yes")},
                new Clause(Portables, cEquals, "Samsung"));
        Rule iphone = new Rule(rb, "Iphone",
                new Clause[]{new Clause(RAm, cEquals, "3GB"),
                        new Clause(Capacite, cEquals, "128gb")
                        ,new Clause(resolution_decran,cEquals,"FULL_HD"),new Clause(systeme,cEquals,"IOS"), new Clause(WiFi, cEquals, "yes")},
                new Clause(Portables, cEquals, "Iphone"));

        Rule Microsoft = new Rule(rb, "Microsoft",
                new Clause[]{new Clause(WiFi, cEquals, "yes"),
                        new Clause(systeme,cEquals,"Windows_Phone"),new Clause(Capteur_photo_principal, cEquals, "8MPX")},
                new Clause(Portables, cEquals, "Microsoft"));

        Rule LG = new Rule(rb, "LG",
                new Clause[]{new Clause(WiFi, cEquals, "yes"),
                        new Clause(systeme,cEquals,"Android"),new Clause(Capteur_photo_principal, cEquals, "12PX")},
                new Clause(Portables, cEquals, "LG"));

        Rule MI = new Rule(rb, "MI",
                new Clause[]{new Clause(WiFi, cEquals, "yes"),new Clause(RAm, cEquals, "4GB"),
                       new Clause(systeme,cEquals,"Android"),new Clause(Capteur_photo_principal, cEquals, "12PX")},
                new Clause(Portables, cEquals, "MI"));
        Rule iphone2=new Rule(rb,"Iphone", new Clause[]{new Clause(systeme,cEquals,"IOS")},new Clause(Portables, cEquals, "Iphone"));
        Rule resolution =new Rule (rb,"FULL_HD",new Clause[]{new Clause(Capteur_photo_principal,cEquals,"20MPX"),new Clause(RAm,cEquals,"4GB")},
        new Clause(resolution_decran,cEquals,"FULL_HD"));


    }

    public static void initVehiculeRuleBase(BooleanRuleBase rb) {
        RuleVariable vehicule = new RuleVariable(rb, "vehicule");
        vehicule.setLabels("Bicycle Tricycle Motorcycle Sports_car Sedan MiniVan Sport_Utility_vehicule");
        vehicule.setPromptText("what kind of vehicule is it?");

        RuleVariable vehiculeType = new RuleVariable(rb, "vehiculeType");
        vehiculeType.setLabels("cycle automobile");
        vehiculeType.setPromptText("what type of vehicule is it?");

        RuleVariable size = new RuleVariable(rb, "size");
        size.setLabels("small medium large");
        vehiculeType.setPromptText("what  size is of the vehicule?");

        RuleVariable motor = new RuleVariable(rb, "motor");
        size.setLabels("yes no");
        vehiculeType.setPromptText("does the vehicule have a motor?");

        RuleVariable num_wheels = new RuleVariable(rb, "num_wheels");
        size.setLabels("2 3 4");
        vehiculeType.setPromptText("how many wheels does it have?");

        RuleVariable num_doors = new RuleVariable(rb, "num_doors");
        size.setLabels("2 3 4");
        vehiculeType.setPromptText("how many doors does it have?");

        Condition cEquals = new Condition("=");
        Condition cNotEquals = new Condition("!=");
        Condition clessThen = new Condition("<");
        Condition cMoreThen = new Condition(">");

        Rule Bicycle = new Rule(rb, "bicycle", new Clause[]{new Clause(vehiculeType, cEquals, "cycle"),
            new Clause(num_wheels, cEquals, "2"), new Clause(motor, cEquals, "no")},
                new Clause(vehicule, cEquals, "Bicycle"));
        Rule Tricycle = new Rule(rb, "Tricycle", new Clause[]{new Clause(vehiculeType, cEquals, "cycle"),
            new Clause(num_wheels, cEquals, "3"), new Clause(motor, cEquals, "no")},
                new Clause(vehicule, cEquals, "Tricycle"));
        Rule Motorcycle = new Rule(rb, "motorcycle", new Clause[]{new Clause(vehiculeType, cEquals, "cycle"),
            new Clause(num_wheels, cEquals, "2"), new Clause(motor, cEquals, "yes")},
                new Clause(vehicule, cEquals, "Motorcycle"));

        Rule SportsCar = new Rule(rb, "sportsCar",
                new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
                    new Clause(num_doors, cEquals, "2"),
                    new Clause(size, cEquals, "small")},
                new Clause(vehicule, cEquals, "Sports_car"));
        Rule Sedan = new Rule(rb, "sedan", new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
            new Clause(num_doors, cEquals, "4"), new Clause(size, cEquals, "medium")},
                new Clause(vehicule, cEquals, "Sedan"));
        Rule MiniVan = new Rule(rb, "miniVan", new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
            new Clause(num_doors, cEquals, "3"), new Clause(size, cEquals, "medium")},
                new Clause(vehicule, cEquals, "MiniVan"));
        Rule SUV = new Rule(rb, "SUV", new Clause[]{new Clause(vehiculeType, cEquals, "automobile"),
            new Clause(num_doors, cEquals, "4"), new Clause(size, cEquals, "large")},
                new Clause(vehicule, cEquals, "Sport_Utility_vehicule"));

        Rule Cycle = new Rule(rb, "Cycle", new Clause(num_wheels, clessThen, "4"),
                new Clause(vehiculeType, cEquals, "cycle"));
        Rule Automobile = new Rule(rb, "Automobile",
                new Clause[]{new Clause(num_wheels, cEquals, "4"),
                    new Clause(motor, cEquals, "yes")},
                new Clause(vehiculeType, cEquals, "automobile"));

    }

    public static void kBLoader(BooleanRuleBase rb, boolean defaultFlag) {

        System.out.println("setting values for Vehicule forward chaining");
        JsonParser parser = new JsonParser();
        Reader rder;
        try {
            if (defaultFlag) {
                rder = new FileReader("C:\\Users\\islam\\Downloads\\Expert-system-master\\Agent_partie1\\src\\" + rb.name + "KB_default.json");
                System.out.println("islam");
            } else {
                rder = new FileReader("C:\\Users\\islam\\Downloads\\Expert-system-master\\Agent_partie1\\src\\" + rb.name + "KB.json");
                System.out.println("islam2");
            }

            JsonElement elemnt = parser.parse(rder);
            JsonObject obj = elemnt.getAsJsonObject();
            Set<String> keys = obj.keySet();
            Iterator<String> element = keys.iterator();

            while (element.hasNext()) {
                String next = element.next();
                 System.out.println(next);
                 System.out.println(obj.get(next).getAsString());
                rb.setVariableValue(next, obj.get(next).getAsString().equals("null") ? null
                        : obj.get(next).getAsString());
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
