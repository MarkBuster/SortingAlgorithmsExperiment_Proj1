import java.util.concurrent.ThreadLocalRandom;

public class QuickSortRandom {

    /**
     * Swaps two elements in an array.
     *
     * @param input the array to swap with.
     * @param first the first element to be swapped.
     * @param second the second element to be swapped.
     */
    private void swap(int[] input, int first, int second) {

        int temporary = input[first];
        input[first] = input[second];
        input[second] = temporary;
    }


    /**
     * Select a random index from the array,
     * then swaps it with the last index.
     *
     * @param input the array to select from and swap with.
     * @param first the first index of the array boundary.
     * @param last the last index of the array boundary.
     */
    private void randomize(int[] input, int first, int last) {

        int pivot = ThreadLocalRandom.current().nextInt(last - first) + first;
        swap(input, pivot, last);
    }

    /**
     * Takes a random element as a pivot,
     * then swaps any elements after the pivot if they are larger.
     * After the partitioning completes, all elements more than the pivot are on the right
     * and all elements less than on the left.
     *
     * @param input the array to be partitioned.
     * @param first the first index of the array boundary.
     * @param last the last index of the array boundary.
     * @return the final sorted position of the pivot.
     */
    private int partition(int[] input, int first, int last) {

        randomize(input, first, last);
        int pivot = input[last];
        int left = first - 1;

        for (int right = first; right < last; right++) {

            if (input[right] < pivot) {

                left++;
                swap(input, left, right);
            }
        }
        swap(input, left + 1, last);

        return left + 1;
    }

    /**
     * Recursive helper method for quickSort().
     * If there are elements left to be sorted, partition() and quick() are called.
     *
     * @param input the array to be sorted.
     * @param first the first index of the array boundary.
     * @param last the last index of the array boundary.
     */
    private void quickSort(int[] input, int first, int last) {

        if (first < last) {

            int partitionIndex = partition(input, first, last);

            quickSort(input, first, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, last);
        }
    }

    /**
     * Sorts an array using a random element as a pivot.
     * <p>
     * Expected a time complexity of O(n log n), which was the the case.
     * There were some minor spikes but in operation time, but they appear inconsistent.
     *
     * @param input the array to be sorted.
     * @return the sorted array.
     */
    public int[] quickSort(int[] input) {

        quickSort(input, 0, input.length - 1);

        return input;
    }
}