public class DataStore {
    public static final double[] values;       //holds all loaded alcohol values

    static {

        try {
            //Load unique alcohol values from both CSV files
            values = WineReader.loadAlcoholValues(
                    "wine+quality/winequality-red.csv",
                    "wine+quality/winequality-white.csv"
            );
        } catch (Exception e) {
            //Convert checked exceptions to runtime exceptions
            throw new RuntimeException(e);
        }


    }
}