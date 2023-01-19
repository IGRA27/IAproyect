/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenedores;
import Agentes.Ag1;
import Agentes.Ag2;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
/**
 *
 * @author Isaac Reyes
 */
public class Contenedor {
    private AgentContainer agentContainer;

    public void crearContenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl(null, 1099, null);
        agentContainer = runtime.createMainContainer(profile);
        agregarAgentes();
    }

    public void agregarAgentes() {
        try {
            agentContainer.createNewAgent("AG4", Ag4.class.getName(), null).start();
            agentContainer.createNewAgent("AG3", Ag3.class.getName(), null).start();
            agentContainer.createNewAgent("ANNR", ANNR.class.getName(), null).start();
            agentContainer.createNewAgent("ANNC", ANNC.class.getName(), null).start();
            agentContainer.createNewAgent("AG", AG.class.getName(), null).start();
            agentContainer.createNewAgent("Ag2", Ag2.class.getName(), null).start();
            agentContainer.createNewAgent("Ag1", Ag1.class.getName(), null).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
