public class QuickSortMedian {

    /**
     * Returns the index of the median value in the array.
     * 
     * @param input the array to be analyzed.
     * @param first the first index of the array boundary.
     * @param last the last index of the array boundary.
     * @return the index of the median value.
     */
    private int median(int[] input, int first, int last) {

        int middle = (first + last) / 2;
        int biggest = Math.max(first, Math.max(middle, last));

        if (biggest == first) {
            return Math.max(middle, last);
        }
        if (biggest == last) {
            return Math.max(first, middle);
        }
        return  Math.max(first, last);
    }

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
     * Takes the element with a median value a pivot,
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

        int median = median(input, first, last);
        int pivot = input[median];
        int left = first;

        swap(input, median, last);

        for (int right = first; right < last; right++) {

            if (input[right] < pivot) {

                swap(input, right, left);
                left++;
            }
        }
        swap(input, last, left);

        return left;
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
     * Sorts an array using the element with the median value as a pivot.
     * <p>
     * Expected a time complexity of O(n log n), which was the case.
     * There were some large spikes in operation time, but they appear inconsistent.
     *
     * @param input the array to be sorted.
     * @return the sorted array.
     */
    public int[] quickSort(int[] input) {

        quickSort(input, 0, input.length - 1);

        return input;
    }
}