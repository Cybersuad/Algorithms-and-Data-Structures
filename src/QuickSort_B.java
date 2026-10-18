public class QuickSort_B {

    public static int comparisonCount = 0;  //counts how many comparisons are made

    public static void main(String[] args) throws Exception {
        //Load the dataset into an array
        double[] values = DataStore.values.clone();

        //Perform QuickSort using the last element as the pivot
        quickSort(values, 0, values.length - 1);

        //Print results and basic verification
        System.out.println("Quick Sort - Last Element Pivot");
        System.out.println("Number of comparisons: " + comparisonCount);
        System.out.println("Sorted correctly: " + isSorted(values));
        System.out.print("First 10 sorted values: ");
        printFirst(values);
    }

    //Sorts the array between indices low and high
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);     //place pivot in correct position
            quickSort(arr, low, pivotIndex - 1);       //sort the left side
            quickSort(arr, pivotIndex + 1, high);       //sort the right side
        }
    }

    //Partition using last element as the pivot
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];       //pivot is the last element
        int leftIndex = low - 1;        //boundary for elements smaller than pivot

        //Scan through the array from low to high
        for (int rightIndex = low; rightIndex < high; rightIndex++) {
            comparisonCount++;    //count each comparison

            //If element is smaller than pivot, move it to the left section
            if (arr[rightIndex] < pivot) {
                leftIndex++;
                swap(arr, leftIndex, rightIndex);
            }
        }

        //Place pivot in its correct sorted position
        swap(arr, leftIndex + 1, high);
        return leftIndex + 1;          //return final pivot position
    }
    //Swaps two elements in the array
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Checks if the array is sorted in ascending order
    public static boolean isSorted(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //Prints the first 10 values of the sorted array
    public static void printFirst(double[] arr) {
        for (int i = 0; i < Math.min(10, arr.length); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
