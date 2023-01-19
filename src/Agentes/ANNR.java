/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;
import jade.core.Agent;
import jade.wrapper.AgentContainer;
import jade.core.ContainerID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static redesneuronales.RegresionRedNeuronal.Regresion;

/*
 *
 * @author Isaac Reyes
 */
public class ANNR {
    @Override
    protected void setup() {
        System.out.println("AgenteR CONFIG");
        addBehaviour(new ComportamientoAgente());
    }

    @Override
    protected void takeDown() {
        System.out.println("Agente R takedown");
    }

    class ComportamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            String[] input = null;

            try {
                input = (String[]) acl.getContentObject();

                System.out.println("Mensaje recibido Ag2 -> AgR");

                String numIslas = Regresion(input);

                Mensajes.enviarMSJ(
                        "Ag3",
                        getAgent(),
                        numIslas,
                        null,
                        ACLMessage.INFORM,
                        "INPUT-AGR-AG3-OBJ",
                        false);

            } catch (UnreadableException ex) {
                Logger.getLogger(Ag2.class.getName()).log(Level.SEVERE, null, ex);
            }

            //doDelete();
        }
    }
}
