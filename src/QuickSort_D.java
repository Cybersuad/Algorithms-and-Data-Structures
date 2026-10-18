public class QuickSort_D {

    public static int comparisonCount = 0;      //counts how many comparisons are made

    public static void main(String[] args) throws Exception {

        //Load the dataset into an array
        double[] values = DataStore.values.clone();

        //Perform QuickSort using the median of three pivot strategy
        quickSort(values, 0, values.length - 1);

        //Print result and basic verification
        System.out.println("Quick Sort - Median of Three Pivot");
        System.out.println("Number of comparisons: " + comparisonCount);
        System.out.println("Sorted correctly: " + isSorted(values));
        System.out.print("First 10 sorted values: ");
        printFirst(values);
    }

    //Sorts the array between indices low and high
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);         //place pivot in correct position
            quickSort(arr, low, pivotIndex - 1);          //sort left side
            quickSort(arr, pivotIndex + 1, high);          //sort right side
        }
    }

    //Partition using the median of three pivot selection
    public static int partition(double[] arr, int low, int high) {

        //choose pivot as the median og first, middle and last element
        int medianIndex = findMedianOfThreeIndex(arr, low, high);
        //move the chosen pivot to th end (Standard quickSort partition position
        swap(arr, medianIndex, high);

        double pivot = arr[high];          //pivot is now the median of three element
        int leftIndex = low - 1;           //boundary for elements smaller than pivot

        //scan through the array from low to high -1
        for (int rightIndex = low; rightIndex < high; rightIndex++) {
            comparisonCount++;          //counts each comparison

            //If element is smaller than pivot, move it to the left selection
            if (arr[rightIndex] < pivot) {
                leftIndex++;
                swap(arr, leftIndex, rightIndex);
            }
        }

        //Place pivot in its correct sorted position
        swap(arr, leftIndex + 1, high);
        return leftIndex + 1;       //return final pivot position
    }

    //Returns the index of the media value among first, middle and last element
    public static int findMedianOfThreeIndex(double[] arr, int low, int high) {

        int mid = (low + high) / 2;

        double first = arr[low];
        double middle = arr[mid];
        double last = arr[high];

        //Check if middle is the median
        if ((first <= middle && middle <= last) || (last <= middle && middle <= first)) {
            return mid;
        }
        //Check if the first is the median
        if ((middle <= first && first <= last) || (last <= first && first <= middle)) {
            return low;
        }
        //Otherwise, last is the median
        return high;
    }
    //Swaps elements in the array
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
