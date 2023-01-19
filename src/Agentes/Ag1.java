/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import model.TestObject;
import java.util.Objects;
/**
 *
 * @author Isaac Reyes
 */
public class Ag1 extends Agent {
    //instanciamos la GUI:
    GUI gui = new GUI();
    @Override
    protected void setup() {

        // Hago visible la GUI en el set up del agente
        gui.setVisible(true);
        addBehaviour(new CompotamientoAgente());
    }
    @Override
    protected void takeDown() {
        System.out.println("Soy "+getName()+ " y estoy muerto.");
    }
    class CompotamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {
            if(gui.actionBolean){
                Mensajes.enviarMSJ("AG2", getAgent(), null,new TestObject(gui.dato1, gui.dato2, gui.dato3, gui.dato4, gui.dato5),
                        ACLMessage.INFORM, "CODAG1-AG2", true
                );

                ACLMessage acl = blockingReceive();
                if(Objects.equals(acl.getConversationId(), "CODAG2-AG1")){
                    gui.txtAreaTxt.append(acl.getContent());
                }

            }

            //doDelete();
        }

    }
    
    
}
