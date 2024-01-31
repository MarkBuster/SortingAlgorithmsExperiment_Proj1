import java.util.ArrayList;
import java.util.Collections;

/**
 * The CountingSort class provides a method for performing counting sort on an ArrayList of integers.
 */
public class CountingSort {

    /**
     * Sorts an ArrayList of integers in ascending order using the counting sort algorithm.
     *
     * @param arr The ArrayList to be sorted.
     */
    public void countingSort(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return;
        }
        // Find the maximum value in the input ArrayList
        int max = Collections.max(arr);
        // Create an array to store counts of each unique element
        int[] count = new int[max + 1];
        // Count occurrences of each element in the input ArrayList
        for (int number : arr) {
            count[number]++;
        }
        int arrIndex = 0;
        // Reconstruct the sorted ArrayList based on counts
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr.set(arrIndex++, i);
                count[i]--;
            }
        }
    }
}
