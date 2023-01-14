package sample;

import Controller.TextController;
import com.jfoenix.controls.JFXDecorator;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.tools.sniffer.Message;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CentralAgent extends Agent {
    String name;
    String info;
    @Override
    protected void setup() {



        SequentialBehaviour comp=new SequentialBehaviour();




        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {


                comp.addSubBehaviour(new OneShotBehaviour()
                {
                    @Override
                    public void action() {
                        ACLMessage msg = receive();
                        while (msg == null) {msg = receive();}

                            //System.out.println(msg.getContent());
                            Object[] arg= new Object[0];
                            name=msg.getContent();
                            //System.out.println(msg.getContent());
                            msg=null;
                            ACLMessage aclmsg = new ACLMessage(ACLMessage.INFORM);
                            aclmsg.setContent(name);
                            switch (name)
                            {
                                case "vehicule":
                                    aclmsg.addReceiver(new AID("Vendeur1", AID.ISLOCALNAME));
                                    send(aclmsg);
                                    break;
                                case "Portable":
                                    aclmsg.addReceiver(new AID("Vendeur2", AID.ISLOCALNAME));
                                    send(aclmsg);

                            }




                    }
                });

                comp.addSubBehaviour(new OneShotBehaviour() {
                    @Override
                    public void action() {
                        ACLMessage msg2 = receive();
                        while (msg2==null){msg2 = receive();}

                        info=msg2.getContent();
                        ACLMessage aclmsg = new ACLMessage(ACLMessage.INFORM);
                        aclmsg.setContent(info);

                        //System.out.println(info);
                        aclmsg.addReceiver(new AID("AgentAcheteur", AID.ISLOCALNAME));
                        send(aclmsg);

                    }
                });
            }
        });









        addBehaviour(comp);




    }
}
