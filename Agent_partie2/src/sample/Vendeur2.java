package sample;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import rule.BooleanRuleBase;
import rule.initRuleBase;

import javax.swing.text.StyledEditorKit;

public class Vendeur2 extends Agent {
    static BooleanRuleBase Prb;
    @Override
    protected void setup()
    {

        Object[] arg=getArguments();
        String name=(String)arg[1];
        BooleanRuleBase rb2 = (BooleanRuleBase)arg[0];
        Prb=rb2;




        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    //Here i want to get the first name of the object Person
                    //System.out.println(msg.getContent());
                    Object[] arg= new Object[0];
                    //System.out.println(msg.getContent());
                    initRuleBase.kBLoader(rb2, false);
                    rb2.forWardChain();
                    ACLMessage aclmsg = new ACLMessage(ACLMessage.INFORM);
                    aclmsg.setContent(rb2.getInformation().toString());
                    //System.out.println("zeaeza");
                    aclmsg.addReceiver(new AID("Central", AID.ISLOCALNAME));
                    send(aclmsg);
                    msg=null;



                }

            }
        });


    }
}
