/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;
import jade.core.Agent;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import model.TestObject;
import java.util.Objects;
/**
 *
 * @author Isaac Reyes
 */
public class Ag2 extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CompotamientoAgente());
    }

    @Override
    protected void takeDown() {
        System.out.println("Soy "+getName()+ " y estoy muerto.");

    }
    
    class CompotamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {

            ACLMessage acl = blockingReceive();

            if(Objects.equals(acl.getConversationId(), "CODAG1-AG2")){
               try{
                   TestObject c = (TestObject) acl.getContentObject();
                   System.out.println("--------------------------------");
                   System.out.println("Agente: " + getName());
                   System.out.println(c);

                   System.out.println("Mensaje ha sido enviado por: " + acl.getSender().getName());;
                   System.out.println("--------------------------------");

                   Mensajes.enviarMSJ(

                           "AG1",
                           getAgent(),
                           c.getVal1()+"EDICIÓN Agente2",
                           null,
                           ACLMessage.INFORM,
                           "CODAG2-AG1",
                           false
                   );

               } catch (UnreadableException e){
                   e.printStackTrace();
               }
            }else{
                System.out.println("SUCEDIÓ ALGO");
            }

        }

    }
    
}
