public class Printer {

    // Prints double[]
    public static void printArray(double[] arr, int limit) {
        if (limit == 0) {
            for (double v : arr) {
                System.out.println(v);
            }
        } else {
            for (int i = 0; i < limit && i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    // Prints ArrayList<T>
    public static <T> void printArray(java.util.ArrayList<T> list, int limit) {
        if (limit == 0) {
            for (T v : list) {
                System.out.println(v);
            }
        } else {
            for (int i = 0; i < limit && i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}