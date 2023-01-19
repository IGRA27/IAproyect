/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;
import static algoritmosgeneticos.AlgoritmoGenetico.iniciarGenetico;
import jade.core.Agent;
import jade.wrapper.AgentContainer;
import jade.core.ContainerID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.StaleProxyException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Isaac Reyes
 */
public class AG {
    @Override
    protected void setup() {
        System.out.println("Agente G TKDN");
        addBehaviour(new ComportamientoAgente());

    }

    @Override
    protected void takeDown() {
        System.out.println("Agente G TKDN");
    }

    class ComportamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            String input = null;

            try {
                input = (String) acl.getContentObject();

                System.out.println("Ag2 -> AgG");

                Integer[] indicesGenetico = iniciarGenetico(input);

                Mensajes.enviarMSJ(
                        "AG3",
                        getAgent(),
                        null,
                        indicesGenetico,
                        ACLMessage.INFORM,
                        "AGG-AG3-OBJ",
                        true);

            } catch (UnreadableException ex) {
                Logger.getLogger(AG.class.getName()).log(Level.SEVERE, null, ex);
            }

            //doDelete();
        }
    }
}
