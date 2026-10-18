public class QuickSort_A {

    public static int comparisonCount = 0;     // counts how many comparisons are made

    public static void main(String[] args) throws Exception {


        //Load the dataset into an array
        double[] values = DataStore.values.clone();

        //Perform QuickSort using the first element as the pivot
        quickSort(values, 0, values.length - 1);

        //Print results and basic verification
        System.out.println("Quick Sort - First Element Pivot");
        System.out.println("Number of comparisons: " + comparisonCount);
        System.out.println("Sorted correctly: " + isSorted(values));
        System.out.print("First 10 sorted values: ");
        printFirst(values);
    }
    //sorts the array between indices low and high
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);     //place pivot in correct position
            quickSort(arr, low, pivotIndex - 1);       //sort left side
            quickSort(arr, pivotIndex + 1, high);       //sort right side
        }
    }
    //partition using the first element as the pivot
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[low];        //pivot is the first element
        int leftIndex = low;            //boundary for elements smaller tha the pivot

        //Scan through the rest of the array
        for (int rightIndex = low + 1; rightIndex <= high; rightIndex++) {
            comparisonCount++;      //count each comparison

            //if element is smaller than pivot, move it to the left section
            if (arr[rightIndex] < pivot) {
                leftIndex++;
                swap(arr, leftIndex, rightIndex);
            }
        }

        //place pivot in its correct sorted position
        swap(arr, low, leftIndex);
        return leftIndex;   //return final pivot position
    }

    //swaps two elements in the array
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Check if the array is sorted in ascending order
    public static boolean isSorted(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    //prints the first 10 values of the sorted array
    public static void printFirst(double[] arr) {
        for (int i = 0; i < Math.min(10, arr.length); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
