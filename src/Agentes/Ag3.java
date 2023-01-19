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

// @author Isaac Reyes

public class Ag3 extends Agent{
    Object[] resultados; // Se va a guardar en el orden: 0 -> regresion | 1 -> clasificacion | 2 -> genetico
    Boolean regresion;
    Boolean clasificacion;
    Boolean genetico;

    @Override
    protected void setup() {
        System.out.println("Agente 3 setup");
        addBehaviour(new ComportamientoAgente());
        resultados = new Object[3];
        regresion = false;
        clasificacion = false;
        genetico = false;
    }

    @Override
    protected void takeDown() {
        System.out.println("Agente 3 takedown");
    }

    class ComportamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl =  blockingReceive();

            try {
                if (acl.getConversationId().equalsIgnoreCase("AGR-AG3-OBJ")) {
                    resultados[0] = (String) acl.getContentObject();
                    System.out.println("AgR -> Ag3");
                    regresion = true;
                } else if (acl.getConversationId().equalsIgnoreCase("AGC-AG3-OBJ")) {
                    resultados[1] = (String) acl.getContentObject();
                    System.out.println("AgC -> Ag3");
                    clasificacion = true;
                } else if (acl.getConversationId().equalsIgnoreCase("AGG-AG3-OBJ")) {
                    resultados[2] = acl.getContentObject();
                    System.out.println("AgG -> Ag3");
                    genetico = true;
                }
            } catch (UnreadableException ex) {
                Logger.getLogger(Ag3.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (regresion & clasificacion & genetico) {
                Mensajes.enviarMSJ(
                        "AG4",
                        getAgent(),
                        null,
                        resultados,
                        ACLMessage.INFORM,
                        "-AG3-4-OBJ",
                        true);

                resultados = new Object[3];
                regresion = false;
                clasificacion = false;
                genetico = false;
            }
        }
    }
    
}
