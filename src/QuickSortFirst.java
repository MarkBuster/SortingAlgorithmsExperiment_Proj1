public class QuickSortFirst {

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
     * Takes the first element a pivot,
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

        int pivot = input[first];
        int right = last;

        for (int left = last; left > first; left--) {

            if (input[left] > pivot) {

                swap(input, left, right--);
            }
        }
        swap(input, first, right);

        return right;
    }

    /**
     * Recursive helper method for quickSort().
     * While there are elements left to be sorted, partition() and quick() are called.
     * Only sorts half of the array at a time to prevent a stackoverflow exception.
     *
     * @param input the array to be sorted.
     * @param first the first index of the array boundary.
     * @param last the last index of the array boundary.
     */
    private void quickSort(int[] input, int first, int last) {

            while (last - first > 0) {

                int partition = partition(input, first, last);

                if ((partition - first) <= (last - partition)) {

                    quickSort(input, first, partition - 1);
                    first = partition + 1;

                } else {

                    quickSort(input, partition + 1, last);
                    last = partition - 1;
                }
            }
    }

    /**
     * Sorts an array using the first element as a pivot.
     * <p>
     * Expected a time complexity of O(n log n),
     * which was the the case unless the array was sorted (both forward and back),
     * which instead results in O(n^2).
     *
     * @param input the array to be sorted.
     * @return the sorted array.
     */
    public int[] quickSort(int[] input) {

        quickSort(input, 0, input.length - 1);

        return input;
    }
}