package conexionjava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStream;
import java.util.ArrayList;
public class ConexionJava {
    /**
     *
     * @author Isaac Reyes
     */
    public static void main(String[] args) {
        ArrayList<String> predicciones = new ArrayList<>();

        String arguments = "28 3.75 0 0 8 0 8 standar 0 2 1 7 2020";
        String path = System.getProperty("user.dir");
        String path_to_env = path + "/src/Agentes/env/bin/python3" ; // apunta al entorno virtual
        path  = path+ "/src/Agentes/python.py";
        try {
            // TODO code application logic here
            String parametros="a b c d e";
            String ruta=System.getProperty("user.dir")+"/src/conexionjava/python.py";
            ProcessBuilder builder= new ProcessBuilder("python ", ruta, parametros);

            Process process=builder.start();
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String resultado="";
            while((resultado=bufferReader.readLine())!=null){
                System.out.println(resultado);

            }

            //String resultado=bufferReader.readLine();
            //System.out.println(resultado);
        } catch (IOException ex) {
            Logger.getLogger(ConexionJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
