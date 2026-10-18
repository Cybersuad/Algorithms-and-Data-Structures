import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingAlgorithms {

    public static void main(String[] args) throws Exception {
        //Load original dataset
        double[] original = DataStore.values.clone();

        //Create different input orders for testing
        double[] randomData = original.clone();

        double[] sortedData = original.clone();
        Arrays.sort(sortedData);

        double[] reversedData = original.clone();
        Arrays.sort(reversedData);
        reverseArray(reversedData);

        //Table header
        System.out.println("Algorithm               | Random (µs) | Sorted (µs) | Reversed (µs)");
        System.out.println("---------------------------------------------------------------------");

        //Runs all algorithms on all input types
        printRow("Bubble (nonoptimised)",
                testBubbleNonoptimised(randomData),
                testBubbleNonoptimised(sortedData),
                testBubbleNonoptimised(reversedData));

        printRow("Bubble (optimised)",
                testBubbleOptimised(randomData),
                testBubbleOptimised(sortedData),
                testBubbleOptimised(reversedData));

        printRow("Insertion",
                testInsertion(randomData),
                testInsertion(sortedData),
                testInsertion(reversedData));

        printRow("MergeSort",
                testMergeSort(randomData),
                testMergeSort(sortedData),
                testMergeSort(reversedData));

        printRow("QuickSort (first)",
                testQuickSortFirst(randomData),
                testQuickSortFirst(sortedData),
                testQuickSortFirst(reversedData));

        printRow("QuickSort (last)",
                testQuickSortLast(randomData),
                testQuickSortLast(sortedData),
                testQuickSortLast(reversedData));

        printRow("QuickSort (random)",
                testQuickSortRandom(randomData),
                testQuickSortRandom(sortedData),
                testQuickSortRandom(reversedData));

        printRow("QuickSort (median)",
                testQuickSortMedian(randomData),
                testQuickSortMedian(sortedData),
                testQuickSortMedian(reversedData));
    }
    //Prints one formatted row in the result table
    public static void printRow(String algorithm, long random, long sorted, long reversed) {
        System.out.printf("%-23s | %-11d | %-11d | %-13d%n",
                algorithm, random, sorted, reversed);
    }
    //Measures execution time of non-optimised Bubble Sort
    public static long testBubbleNonoptimised(double[] source) {
        double[] arr = source.clone();
        Timer timer = new Timer();
        timer.begin();
        BubbleSort.bubbleSort(arr);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of optimised Bubble Sort
    public static long testBubbleOptimised(double[] source) {
        double[] arr = source.clone();
        Timer timer = new Timer();
        timer.begin();
        BubbleSort.bubbleSortOptimised(arr);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of Insertion Sort
    public static long testInsertion(double[] source) {
        ArrayList<Double> list = toArrayList(source);
        Timer timer = new Timer();
        timer.begin();
        InsertionSort.insertionSort(list);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of MergeSort
    public static long testMergeSort(double[] source) {
        ArrayList<Double> list = toArrayList(source);
        MergeSort.mergeCount = 0;
        Timer timer = new Timer();
        timer.begin();
        MergeSort.mergeSort(list, 0, list.size() - 1);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of QuickSort (first element pivot)
    public static long testQuickSortFirst(double[] source) {
        double[] arr = source.clone();
        QuickSort_A.comparisonCount = 0;
        Timer timer = new Timer();
        timer.begin();
        QuickSort_A.quickSort(arr, 0, arr.length - 1);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of QuickSort (last element pivot)
    public static long testQuickSortLast(double[] source) {
        double[] arr = source.clone();
        QuickSort_B.comparisonCount = 0;
        Timer timer = new Timer();
        timer.begin();
        QuickSort_B.quickSort(arr, 0, arr.length - 1);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of QuickSort (random element pivot)
    public static long testQuickSortRandom(double[] source) {
        double[] arr = source.clone();
        QuickSort_C.comparisonCount = 0;
        Timer timer = new Timer();
        timer.begin();
        QuickSort_C.quickSort(arr, 0, arr.length - 1);
        timer.finish();
        return timer.getMicroTime();
    }
    //Measures execution time of QuickSort (median of three pivot)
    public static long testQuickSortMedian(double[] source) {
        double[] arr = source.clone();
        QuickSort_D.comparisonCount = 0;
        Timer timer = new Timer();
        timer.begin();
        QuickSort_D.quickSort(arr, 0, arr.length - 1);
        timer.finish();
        return timer.getMicroTime();
    }
    //Convert double[] to an ArrayList<Double>
    public static ArrayList<Double> toArrayList(double[] arr) {
        ArrayList<Double> list = new ArrayList<>();
        for (double v : arr) {
            list.add(v);
        }
        return list;
    }
    //Reverses the order of double[] array
    public static void reverseArray(double[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            double temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

