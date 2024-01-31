import java.util.ArrayList;

/**
 * The SelectionSort class provides a method for performing selection sort on an ArrayList of integers.
 */
public class SelectionSort {

    /**
     * Sorts an ArrayList of integers in ascending order using the selection sort algorithm.
     *
     * @param arr The ArrayList to be sorted.
     */
    public void selectionSort(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {

            // Find the index of the minimum element in the unsorted portion of the ArrayList
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the minimum element with the current element
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }
}
