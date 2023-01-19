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
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import static redesneuronales.ClasificacionRedNeuronal..Clasificacion;
import static redesneuronales.RegresionRedNeuronal..Regresion;
/**
 *
 * @author Isaac Reyes
 */
public class ANNC {
    @Override
    protected void setup() {
        System.out.println("Agente C CONFIG");
        addBehaviour(new ComportamientoAgente());

    }

    @Override
    protected void takeDown() {
        System.out.println("Agente C TKDN");
    }

    class ComportamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            String[] input = null;

            try {
                input = (String[]) acl.getContentObject();

                System.out.println("Ag2 -> AgC");

                String cantidadIslas = Clasificacion(input);

                Mensajes.enviarMSJ(
                        "AG3",
                        getAgent(),
                        cantidadIslas,
                        null,
                        ACLMessage.INFORM,
                        "AGC-AG3-OBJ",
                        false);

            } catch (UnreadableException ex) {
                java.util.logging.Logger.getLogger(ANNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            //doDelete();
        }
    }
}
