import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {

    static int mergeCount = 0;     // counts how many merge operations are performed

    public static void main(String[] args) throws Exception {

        //Load all unique alcohol values into a list
        ArrayList<Double> originalValues = loadUniqueValues();

        //Create two list one in original order, and one that shuffled
        ArrayList<Double> normalValues = new ArrayList<>(originalValues);
        ArrayList<Double> shuffledValues = new ArrayList<>(originalValues);

        Collections.shuffle(shuffledValues);    //randomise the order for testing

        Timer timer = new Timer();
        //Measure MergeSort performance on the original order
        mergeCount = 0;
        timer.begin();
        mergeSort(normalValues, 0, normalValues.size() - 1);
        timer.finish();
        long originalTime = timer.getMicroTime();
        int originalMergeCount = mergeCount;

        //Measure MergeSort performance on the shuffled order
        mergeCount = 0;
        timer.begin();
        mergeSort(shuffledValues, 0, shuffledValues.size() - 1);
        timer.finish();
        long shuffledTime = timer.getMicroTime();
        int shuffledMergeCount = mergeCount;

        //Print timing and merge operation results
        System.out.println("MergeSort time (original order): " + originalTime + " µs (micro seconds)");
        System.out.println("Number of merge operations (original order): " + originalMergeCount);

        System.out.println();

        System.out.println("MergeSort time (shuffled order): " + shuffledTime + " µs (micro seconds)");
        System.out.println("Number of merge operations (shuffled order): " + shuffledMergeCount);

        System.out.println();
        System.out.println("Sorted alcohol values:");
        Printer.printArray(shuffledValues, 0);      //print final sorted output
    }
    //Loads unique alcohol values into ArrayList<Double>
    private static ArrayList<Double> loadUniqueValues() throws Exception {
        double[] values = DataStore.values.clone();

        HashSet<Double> set = new HashSet<>();      //HashSet removes duplicates
        for (double v : values) {
            set.add(v);
        }

        return new ArrayList<>(set);            //convert back to ArrayList
    }
    //Recursive MergeSort splits the list into halves until single elements remain
    public static void mergeSort(ArrayList<Double> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);                  //sort left half
            mergeSort(arr, mid + 1, right);         //sort right half

            merge(arr, left, mid, right);               //merge the two sorted halves
        }
    }
    //Merges two sorted halves into one sorted section
    public static void merge(ArrayList<Double> arr, int left, int mid, int right) {

        mergeCount++;          //count how many merge operations occur

        ArrayList<Double> temp = new ArrayList<>();     //temporary list merged values

        int i = left;           //pointer for left half
        int j = mid + 1;        //pointer for the right half

        //Merge elements in sorted order
        while (i <= mid && j <= right) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }
        //add remaining elements from the left half
        while (i <= mid) {
            temp.add(arr.get(i++));
        }
        //add remaining elements from the right left
        while (j <= right) {
            temp.add(arr.get(j++));
        }
        //Copy merged values back into the original array
        for (int k = 0; k < temp.size(); k++) {
            arr.set(left + k, temp.get(k));
        }
    }
}
