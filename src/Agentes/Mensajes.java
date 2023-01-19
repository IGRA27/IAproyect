/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;

import jade.core.Agent;
import model.TestObject;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
/**
 *
 * @author Isaac Reyes
 */
public class Mensajes {
    public static void enviarMSJ(String receptorAlias, Agent emisor, String contenido, Serializable contenidoObject,
                                 int tipo, String idConversacion, boolean tipoContenidoObject){
        ACLMessage acl = new ACLMessage(tipo);
        if(tipoContenidoObject){
            try {
                acl.setContentObject(contenidoObject);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            acl.setContent(contenido);

        }
        acl.setConversationId(idConversacion);
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setSender(emisor.getAID());
        AID aid = new AID();
        aid.setLocalName(receptorAlias);
        acl.addReceiver(aid);
        emisor.send(acl);

    }

   
    }
    

