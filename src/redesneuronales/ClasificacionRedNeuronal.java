package redesneuronales;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import static redesneuronales.FE.formEncoding;
import static redesneuronales.FE.isNumeric;
public class ClasificacionRedNeuronal {
    /**
     *
     * @author Isaac Reyes
     *
     */
    public static String Clasificacion(String[] features) {
        try {
            features = formEncoding(features);

            String ruta = System.getProperty("user.dir") + "\\src\\redesneuronales\\pythonclasificacion.py";

            ProcessBuilder builder = new ProcessBuilder("python", ruta,
                    features[0],
                    features[1],
                    features[2],
                    features[3],
                    features[4],
                    features[5],
                    features[6],
                    features[7],
                    features[8],
                    features[9],
                    features[10],
                    features[11],
                    features[12]);

            Process process = builder.start();

            BufferedReader bufferReader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );

            String resultado = "";

            while((resultado = (bufferReader.readLine())) != null) {
                if(isNumeric(resultado)) {

                    return resultado;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(RegresionRedNeuronal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }
}
