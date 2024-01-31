import java.util.ArrayList;

/**
 * The ShellSort class provides a method for performing shell sort on an ArrayList of integers.
 */
public class ShellSort {

    /**
     * Sorts an ArrayList of integers in ascending order using the shell sort algorithm.
     *
     * @param arr The ArrayList to be sorted.
     */
    public void shellSort(ArrayList<Integer> arr) {
        int n = arr.size();

        // Start with a large gap and reduce it over iterations
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr.get(i);
                int j;
                // Shift elements to the right within the gap until the correct position is found
                for (j = i; j >= gap && arr.get(j - gap) > temp; j -= gap)
                    arr.set(j, arr.get(j - gap));
                // Place the current element in its correct position
                arr.set(j, temp);
            }
        }
    }
}