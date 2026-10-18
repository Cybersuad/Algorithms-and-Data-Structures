import java.util.Random;

public class BubbleSort {

   public static void main(String[] args) throws Exception {
        // Load the original dataset and create two copies
        double[] values = DataStore.values.clone();

        double[] arr1 = values.clone(); //used for the non-optimised Bubble Sort
        double[] arr2 = values.clone(); //used for the optimised Bubble Sort

        Timer timer = new Timer();

        //Measure time for the non-optimised Bubble Sort on the original dataset
        timer.begin();
        bubbleSort(arr1);
        timer.finish();
        System.out.println("Non-optimised Bubble Sort time (original): " + timer.getMicroTime() + " µs");

        //Measure time for the optimised Bubble Sort on the original dataset
        timer.begin();
        bubbleSortOptimised(arr2);
        timer.finish();
        System.out.println("Optimised Bubble Sort time (original): " + timer.getMicroTime() + " µs");

        //Create two new copies that will be shuffled
        double[] shuffled1 = values.clone();
        double[] shuffled2 = values.clone();

        //Shuffle both arrays randomly
        shuffleArray(shuffled1);
        shuffleArray(shuffled2);

        //Measure time for the non-optimised Bubble sort on the Shuffled dataset
        timer.begin();
        bubbleSort(shuffled1);
        timer.finish();
        System.out.println("Non-optimised Bubble Sort time (shuffled): " + timer.getMicroTime() + " µs");

        //Measure time for the optimised Bubble Sort on the shuffled dataset
        timer.begin();
        bubbleSortOptimised(shuffled2);
        timer.finish();
        System.out.println("Optimised Bubble Sort time (shuffled): " + timer.getMicroTime() + " µs");

        //Print the sorted values from the non-optimised and optimised Bubble Sort
        System.out.println("\nSorted values (Non-optimised):");
        Printer.printArray(arr1, 0);
        System.out.println("\nSorted values (Optimised):");
        Printer.printArray(arr2, 0);
    }

    //Shuffles the array randomly using the Fisher-Yates algorithm
    public static void shuffleArray(double[] arr) {
        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); //Random index between 0 an i

            //swaps elements at positions i and j
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //Non-optimised Bubble sort. Compares all neighbouring elements in every pass
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {               //Outer loop: always runs n times
            for (int j = 0; j < n - 1; j++) {       //Inner loop: compares neighbours
                if (arr[j] > arr[j + 1]) {          //swap if they are in the wrong order
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //Optimised Bubble Sort. Stops early id no swap happen in a pass
    public static void bubbleSortOptimised(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;                // Tracks if any swap happens

            for (int j = 0; j < n - i - 1; j++) {   //Fewer comparisons each round
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;                 // a swap occurred
                }
            }
            if (!swapped) {                        // if no swaps, the array is sorted
                break;                             // stop early
            }
        }
    }
}
