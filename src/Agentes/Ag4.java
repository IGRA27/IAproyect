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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Isaac Reyes
 */
public class Ag4 extends Agent{
    @Override
    protected void setup() {
        System.out.println("Agente4CONF");
        addBehaviour(new ComportamientoAgente());

    }

    @Override
    protected void takeDown() {
        System.out.println("AgenteTKDN4");
    }

    class ComportamientoAgente extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage acl =  blockingReceive();

            try {
                Object[] resultados = (Object[]) acl.getContentObject(); // Se va a guardar en el orden: 0 -> regresion | 1 -> clasificacion | 2 -> genetico
                System.out.println("Ag3 -> Ag4");
                System.out.println("Regresion: " + (String) resultados[0]);
                System.out.println("Clasificacion: " + (String) resultados[1]);
                System.out.println("Genetico: " + Arrays.toString((String[]) resultados[2]));
            } catch (UnreadableException ex) {
                Logger.getLogger(Ag4.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
