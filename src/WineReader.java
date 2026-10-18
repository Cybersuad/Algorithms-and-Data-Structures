import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class WineReader {
    //Loads unique alcohol values from both red and white CSV files.
    public static double[] loadAlcoholValues(String redPath, String whitePath) throws Exception {
        Set<Double> alcoholSet = new HashSet<>();

        loadFile(redPath, alcoholSet);  //Read red whine file
        loadFile(whitePath, alcoholSet); //read white wine file
        //Convert set<Double> to double[]
        double[] result = new double[alcoholSet.size()];
        int i = 0;
        for (double value : alcoholSet) {
            result[i++] = value;
        }
        return result;
    }
    //Reads a single CSV file and extracts alcohol values
    private static void loadFile(String path, Set<Double> alcoholSet) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        br.readLine(); // Skip header line

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            double alcohol = Double.parseDouble(parts[10]); // Column 11 = alcohol
            alcoholSet.add(alcohol);
        }

        br.close(); // Close file reader
    }
}