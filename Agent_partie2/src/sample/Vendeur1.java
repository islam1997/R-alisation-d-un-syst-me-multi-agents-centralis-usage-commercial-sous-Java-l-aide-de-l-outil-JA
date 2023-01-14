package sample;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;
import rule.BooleanRuleBase;
import rule.initRuleBase;

public class Vendeur1 extends Agent {
    String name;
    boolean b;
    static public BooleanRuleBase Vrb;
    @Override
    protected void setup() {

        Object[] arg=getArguments();
        String name=(String)arg[1];
        BooleanRuleBase rb1 = (BooleanRuleBase)arg[0];

        Vrb=rb1;


        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    //Here i want to get the first name of the object Person
                    //System.out.println(msg.getContent());
                    Object[] arg= new Object[0];
                    //System.out.println(msg.getContent());
                    initRuleBase.kBLoader(rb1, false);
                    rb1.forWardChain();

                    ACLMessage aclmsg = new ACLMessage(ACLMessage.INFORM);
                    aclmsg.setContent(rb1.Getinformation2());
                    //System.out.println("zeaeza");
                    aclmsg.addReceiver(new AID("Central", AID.ISLOCALNAME));
                    send(aclmsg);
                    msg=null;



                }

            }
        });



            //System.out.println("I am here");

    }
}
