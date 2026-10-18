import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

    public static void main(String[] args) throws Exception {
        //Load all alcohol values into an ArrayLis<Double>
        ArrayList<Double> alcoholValues = loadAsList();

        Timer timer = new Timer();

        //Measure time for sorting the original list
        timer.begin();
        insertionSort(alcoholValues);
        timer.finish();

        System.out.println("Time it took to sort: "
                + timer.getMicroTime() + " µs (micro seconds)");
        //Check if the list is correctly sorted
        if (!isSorted(alcoholValues)) {
            System.out.println("Error: Wrong output after sorting!");
        }
        //Shuffle the list to test performance on randomised data
        Collections.shuffle(alcoholValues);

        //Measure time for sorting the shuffle list
        timer.begin();
        insertionSort(alcoholValues);
        timer.finish();

        System.out.println("Time (shuffled): "
                + timer.getMicroTime() + " µs (micro seconds)");
    //Print all sorted values for verification
        System.out.println("\nAll alcohol values sorted:");
        Printer.printArray(alcoholValues, 0);
    }
    //Loads the dataset into an ArrayList<Double>
    private static ArrayList<Double> loadAsList() throws Exception {
        double[] values = DataStore.values.clone();

        ArrayList<Double> list = new ArrayList<>();
        for (double v : values) {
            list.add(v);
        }
        return list;
    }
    //Standard Insertion Sort. Builds the sorted list one element at a time
    public static void insertionSort(ArrayList<Double> values) {
        for (int i = 1; i < values.size(); i++) {
            double currentValue = values.get(i);        //value to insert
            int j = i;

            //Shift larger elements to the right until the correct position is found
            while (j > 0 && values.get(j - 1) > currentValue) {
                values.set(j, values.get(j - 1));
                j--;
            }
            //Insert the value at its correct position
            values.set(j, currentValue);
        }
    }
    //Checks if the list is sorted in ascending order
    public static boolean isSorted(ArrayList<Double> values) {
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i - 1) > values.get(i)) {
                return false;               //found an incorrect order
            }
        }
        return true;                      //list is sorted
    }
}
