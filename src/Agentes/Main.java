/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Agentes;
import contenedores.Contenedor;
import Agentes.Contenedor;
import algoritmosgeneticos.AlgoritmoGenetico;
import algoritmosgeneticos.CargarCSV;
import static algoritmosgeneticos.CargarCSV.CsvToArray;
import java.util.logging.Level;
import java.util.logging.Logger;
import static redesneuronales.ClasificacionRedNeuronal.Clasificacion;
import static redesneuronales.RegresionRedNeuronal.Regresion;
/**
 *
 * @author Isaac Reyes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        data = CargarCSV.CsvToArray();
        new Contenedor("prueba").crearContenedor();
    }
    
}
