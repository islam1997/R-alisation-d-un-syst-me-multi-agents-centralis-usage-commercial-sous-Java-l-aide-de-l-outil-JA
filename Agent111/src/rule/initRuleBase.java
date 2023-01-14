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
import java.util.*;


public class initRuleBase {

    public static void initclothingRuleBase(BooleanRuleBase r)
    {

        r.goalClauseStack = new Stack() ; // goals and subgoals
        r.variableList = new Hashtable() ;



        //        r.variableList.put(clothes.name, clothes) ;
// /* vetements*/
        RuleVariable hautType = new RuleVariable(r,"HautType") ;
        hautType.setLabels("demi-manche manche-longue trois-quart") ;
        hautType.setPromptText("What type of haut is it?") ;
        //  AgentPart1.RuleApplet.waitForAnswer(hautType.promptText,hautType.getLabels());
        r.variableList.put(hautType.name, hautType) ;
        RuleVariable bas = new RuleVariable(r,"BasType") ;
        bas.setLabels("court long demi") ;

        bas.setPromptText("What type of BasType is it?") ;
        r.variableList.put(bas.name,bas ) ;
        RuleVariable veste = new RuleVariable(r,"Veste(Jacket)") ;
        veste.setLabels("légère épaisse mi-saison") ;
        veste.setPromptText("What type of Jacket is it?") ;
        r.variableList.put(veste.name,veste ) ;

        RuleVariable tissuType = new RuleVariable(r,"TissuType") ;
        tissuType.setLabels("foulard toile cuire coton jean") ;
        tissuType.setPromptText("What type of tissu(material) is it?") ;
        r.variableList.put(tissuType.name, tissuType) ;
        RuleVariable Boutons = new RuleVariable(r,"Boutons") ;
        Boutons.setLabels("0 1 2 3 4 5") ;
        Boutons.setPromptText("How many boutons does  it have ?") ;
        r.variableList.put(Boutons.name, Boutons) ;
        RuleVariable shoes = new RuleVariable(r,"Chaussures") ;
        shoes.setLabels("hiver été mi-saison") ;
        shoes.setPromptText("What type of Chaussures is it?") ;
        r.variableList.put(shoes.name,shoes ) ;
        RuleVariable Zip = new RuleVariable(r,"Zipper") ;
        Zip.setLabels("yes no") ;
        Zip.setPromptText("Do you want  a zipper?") ;
        r.variableList.put(Zip.name,Zip ) ;
        RuleVariable clothes = new RuleVariable(r,"Clothes") ;
        clothes.setPromptText("What type of clothes  is it?") ;
        r.variableList.put(clothes.name, clothes) ;

        RuleVariable Pant = new RuleVariable(r,"Pantalon") ;
        Pant.setLabels("short panta-à-cheville pantacourt ") ;
        Pant.setPromptText("what kind of pant you want?") ;
        r.variableList.put(Pant.name,Pant ) ;


        RuleVariable Skirt = new RuleVariable(r,"Jupe") ;
        Skirt.setLabels("courte medi maxi") ;
        Skirt.setPromptText("what kind of Skirt you want?") ;
        r.variableList.put(Skirt.name,Skirt ) ;


        RuleVariable Forme = new RuleVariable(r,"Forme") ;
        Forme.setLabels("Evasé Droit Tubes") ;
        Forme.setPromptText("what shape do you want?") ;
        r.variableList.put(Forme.name,Forme ) ;


        RuleVariable price = new RuleVariable(r,"Prix") ;
        price.setLabels("1000da 2000da 2500da 5000da 4000da 10000da 6000da " +
                "3000da 7000da 8000da 9000da") ;
        price.setPromptText("How much are u willing to lose (money)?") ;
        r.variableList.put(price.name,price ) ;

/*

        AgentPart1.RuleVariable color = new AgentPart1.RuleVariable("Couleurs") ;
        color.setLabels("Rouge Noire Beige Gris Bleu") ;
        color.setPromptText("which color do you want, sweety?") ;
        r.variableList.put(color.name,color ) ;

*/




        /* vetement**********************************/


// Note: at this point all variables values are NULL
        Condition cEquals = new Condition("=") ;
        Condition cNotEquals = new Condition("!=") ;
        Condition cmoreThan = new Condition(">") ;

// define rules
        r.ruleList = new Vector() ;
        Rule Tee_shirt = new Rule(r, "T_shirt",
                new Clause[]{new Clause(hautType,cEquals, "demi-manche") ,
                new Clause(tissuType,cEquals, "coton"),
                new Clause(Boutons, cEquals, "0"),},
                new Clause(clothes, cEquals, "T_shirt_demi_manche")) ;


        Rule Sweater = new Rule(r, "Sweater",
                new Clause[]{new Clause(hautType,cEquals, "manche_longue"),
                new Clause(tissuType,cEquals, "coton"),
                new Clause(Boutons, cEquals, "0")},
                new Clause(clothes, cEquals, "Sweater_mi_saison"));
        Rule Sweater_cuire = new Rule(r, "Sweater",
                new Clause[]{new Clause (hautType,cEquals, "manche_longue"),
                new Clause(tissuType,cEquals, "cuire"),
                new Clause(Boutons, cEquals, "0")},
                new Clause(clothes, cEquals, "Sweater_cuire")) ;
        Rule Sweater_transparent = new Rule(r, "Sweater",
                new Clause[]{new Clause(hautType,cEquals, "manche_longue") ,
                new Clause(tissuType,cEquals, "foulard"),
                new Clause(Boutons, cEquals, "0")},
                new Clause(clothes, cEquals, "Sweater_transparent(trendy)")) ;






        Rule Gilet= new Rule(r, "Gilet",
                new Clause[]{new Clause(hautType,cEquals, "manche_longue") ,
                new Clause(tissuType,cEquals, "coton"),
                new Clause(Boutons, cmoreThan, "0")},
                new Clause(clothes, cEquals, "Gilet_mi_saison")) ;


        Rule Giletsummer= new Rule(r, "Gilet_été",
                new Clause[]{new Clause(hautType,cEquals, "demi-manche") ,
                new Clause(tissuType,cEquals, "coton"),
                new Clause(Boutons, cmoreThan, "0")},
                new Clause(clothes, cEquals, "Gilet_été")) ;



        Rule Bumber_cuire = new Rule(r, "Bumbers _en_cuire",
                new Clause[]{new Clause(veste,cEquals, "épaisse") ,
                new Clause(tissuType,cEquals, "cuire"),
                new Clause(Zip, cNotEquals, "no")},
                new Clause(clothes, cEquals, "Bumbers_en_cuire")) ;


        Rule Bumber = new Rule(r, "Bumbers",
                new Clause[]{new Clause(veste,cEquals, "épaisse") ,
                new Clause(tissuType,cEquals, "foulard"),
                new Clause(Zip, cNotEquals, "no")},
                new Clause(clothes, cEquals, "Bumbers_foulard(trendy)")) ;




        Rule Blazer = new Rule(r, "Blazer_en_cuire",
                new Clause[]{new Clause(veste,cEquals, "mi-saison") ,
                new Clause(tissuType,cEquals, "cuire"),
                new Clause(Boutons, cEquals, "1")},
                new Clause(clothes, cEquals, "Blazer_en_cuire")) ;





        Rule Blazerclassic = new Rule(r, "Blazer_classic",
                new Clause[]{new Clause(hautType,cEquals, "manche_longue") ,
                new Clause(tissuType,cEquals, "toile"),
                new Clause(Boutons, cEquals, "1")},
                new Clause(clothes, cEquals, "Blazer_classic")) ;






        Rule  pant_short = new Rule(r, "Pant_Short",
                new Clause[]{new Clause(bas,cEquals, "court") ,
                new Clause(Forme,cEquals, "Tubes")},

                new Clause(Pant, cEquals, "short")) ;


        Rule  pant_long = new Rule(r, "Pant_à_cheville",
                new Clause[]{new Clause(bas,cEquals, "long") ,
                new Clause(Forme,cEquals, "Tubes")},

                new Clause(Pant, cEquals, "panta-à-cheville")) ;


        Rule  pant_court = new Rule(r, "pantacourt ",
                new Clause[]{new Clause(bas,cEquals, "demi") ,
                new Clause(Forme,cEquals, "Tubes")},

                new Clause(Pant, cEquals, "pantacourt")) ;




        Rule  short_jean = new Rule(r, "short_en_jean ",
                new Clause[]{new Clause(Pant, cEquals, "short") ,
                new Clause(tissuType,cEquals, "jean"),

                new Clause(clothes, cEquals, "Short_en_jean")}, new Clause(price, cEquals, "3000da")) ;

        Rule  short_jean2 = new Rule(r, "short_en_jean ",
                new Clause[]{new Clause(Pant, cEquals, "short") ,
                        new Clause(tissuType,cEquals, "jean"),

                         new Clause(price, cEquals, "3000da")} ,new Clause(clothes, cEquals, "Short_en_jean")) ;



        Rule  short_classic = new Rule(r, "Classic_short",
                new Clause[]{new Clause(Pant, cEquals, "short") ,
                new Clause(tissuType,cEquals, "toile")},

                new Clause(clothes, cEquals, "Classic_short")) ;


        Rule  short_rock = new Rule(r, "Rock_short",
                new Clause[]{new Clause(Pant, cEquals, "short") ,
                new Clause(tissuType,cEquals, "cuire"),

                new Clause(clothes, cEquals, "rock_short")} ,new Clause(price, cEquals, "2000da"));



        Rule  short_rock2 = new Rule(r, "Rock_short",
                new Clause[]{new Clause(Pant, cEquals, "short") ,
                        new Clause(tissuType,cEquals, "cuire"),

                        new Clause(price, cEquals, "2000da")} ,new Clause(clothes, cEquals, "rock_short"));


        Rule  pantacourt_jean = new Rule(r, "pantacourt_en_jean ",
                new Clause[]{new Clause(Pant, cEquals, "pantacourt") ,
                new Clause(tissuType,cEquals, "jean"),

                new Clause(clothes, cEquals, "pantacourt_en_jean")}, new Clause(price, cEquals, "4000da")) ;

        Rule  pantacourt_jean2 = new Rule(r, "pantacourt_en_jean ",
                new Clause[]{new Clause(Pant, cEquals, "pantacourt") ,
                        new Clause(tissuType,cEquals, "jean"),

                        new Clause(price, cEquals, "4000da")},new Clause(clothes, cEquals, "pantacourt_en_jean")) ;



        Rule  pantacourt_classic = new Rule(r, "Classic_pantacourt",
                new Clause[]{new Clause(Pant, cEquals, "pantacourt") ,
                new Clause(tissuType,cEquals, "toile"),

                new Clause(clothes, cEquals, "Classic_pantacourt")},
                new Clause(price, cEquals, "2000da")) ;









        clothes.setLabels("rock_pantacourt panta-à-cheville_en_jean panta-à-cheville_en_cuire panta-à-cheville_classic"+
                "Maxi-jupe-classic Maxi-jupe-enCuire  Maxi-jupe-enJeans" +
                "Blouse " +
                "Mini-jupe-classic Mini-jupe-enCuire  Mini-jupe-enJeans" +
                "Chemisier" +
                "Jupe-crayon-enJeans jupe-crayon-enCuire Jupe-patineuse-classic" +
                "Classic_pantacourt pantacourt_en_jean" +
                "T_shirt_demi_manche Gilet_mi_saison " +
                "Sweater_mi_saison " +
                "Bumbers_en_cuire" +
                " Short_en_jean " +
                "Classic_short Gilet_été" +
                "rock_short" +
                " Blazer_en_cuire" +
                " Blazer_classic Sweater_transparent(trendy) Sweater_cuire") ;











    }


    public static void initProtableBAse(BooleanRuleBase rb) {

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
        //RAm.setPromptText("RAM?");

        RuleVariable Capacite = new RuleVariable(rb, "capacite");
        Capacite.setLabels("32GB 64GB 128GB");
        Capacite.setPromptText("Cpacite?");

        RuleVariable DoubleCartesim = new RuleVariable(rb, "double_Sim");
        DoubleCartesim.setLabels("yes no");
        DoubleCartesim.setPromptText("Doublesim?");
        RuleVariable argent=new RuleVariable(rb,"Argent");
        argent.setLabels("500 800 1200 1600 2000");


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
        Condition cNotEquals = new Condition("!=");
        Condition clessThen = new Condition("<");
        Condition cMoreThen = new Condition(">");

        Rule Huawei = new Rule(rb, "Huawei",
                new Clause[]{new Clause(RAm, cEquals, "3gb"),
                    new Clause(Capacite, cEquals, "64GB")
                ,new Clause(resolution_decran,cEquals,"HD"),new Clause(systeme,cEquals,"Android")},
                new Clause(Portables, cEquals, "Huawei"));
        Rule htc22 = new Rule(rb, "HTC",
                new Clause[]{new Clause(systeme, cEquals, "Android")},new Clause(Portables, cEquals, "HTC"));
        Rule Huawei2 = new Rule(rb, "Samsung",
                new Clause[]{new Clause(systeme, cEquals, "Android")},new Clause(Portables, cEquals, "Samsung"));
        Rule Microsft2 = new Rule(rb, "Microsoft",
                new Clause[]{new Clause(systeme, cEquals, "Windows_Phone")},new Clause(Portables, cEquals, "Microsoft"));
        Rule LG2 = new Rule(rb, "LG",
                new Clause[]{new Clause(systeme, cEquals, "Android")},new Clause(Portables, cEquals, "LG"));

        Rule HTC = new Rule(rb, "HTC",
                new Clause[]{new Clause(WiFi, cEquals, "no"),
                    new Clause(Capteur_photo_principal, cEquals, "3MPX")},
                new Clause(Portables,cEquals,"HTC"));
        Rule Samsung = new Rule(rb, "Samsung",
                new Clause[]{new Clause(RAm, cEquals, "4gb"),

                        new Clause(Capacite, cEquals, "128GB")
                        ,new Clause(resolution_decran,cEquals,"FULL_HD"),new Clause(systeme,cEquals,"Android"), new Clause(WiFi, cEquals, "yes")},
                new Clause(Portables, cEquals, "Samsung"));
        Rule iphone = new Rule(rb, "Iphone",
                new Clause[]{new Clause(RAm, cEquals, "3gb"),
                        new Clause(Capacite, cEquals, "128GB")
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
                new Clause[]{new Clause(WiFi, cEquals, "yes"),new Clause(RAm, cEquals, "4gb"),
                       new Clause(systeme,cEquals,"Android"),new Clause(Capteur_photo_principal, cEquals, "12PX")},
                new Clause(Portables, cEquals, "MI"));
        Rule iphone2=new Rule(rb,"Iphone", new Clause[]{new Clause(systeme,cEquals,"IOS")},new Clause(Portables, cEquals, "Iphone"));
        Rule resolution =new Rule (rb,"FULL_HD",new Clause[]{new Clause(Capteur_photo_principal,cEquals,"20MPX"),new Clause(RAm,cEquals,"4gb")},
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
