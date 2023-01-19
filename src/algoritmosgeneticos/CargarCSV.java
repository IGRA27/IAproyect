package algoritmosgeneticos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//ISAAC REYES
public class CargarCSV {
    public static String[][] CsvToArray() {
        ArrayList<String[]> data = new ArrayList<String[]>();
        String fileName = "Data.csv";

        String path = System.getProperty("user.dir") + "\\src\\algoritmosgeneticos\\";

        fileName = path + fileName;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String[] values = new String[st.countTokens()];
                for (int i = 0; i < values.length; i++) {
                    values[i] = st.nextToken();
                }
                data.add(values);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[][] arrayData = data.toArray(new String[data.size()][]);

        String[][] arrayToReturn = new String[1000][];

        for(int i = 0; i < 1000; i++) {
            arrayToReturn[i] = arrayData[i + 1];
        }

        return arrayToReturn;
    }
}
