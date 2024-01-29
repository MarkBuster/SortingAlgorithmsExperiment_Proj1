    /**
     * The InsertionSort class provides a method to perform insertion sort on an array of integers.
     * Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time.
     * Best Case: O(n)
     * Average Case: O(n^2)
     * Worst Case: O(n^2)
     * The empirical results reflex the theoretical result where the data sort the fastest when
     * the original array is mostly sorted.
     */
public class InsertionSort {
        /**
         * Sorts an array of integers using the Insertion Sort algorithm.
         *
         * @param array The array of integers to be sorted.
         */
    public void insertionSort(int[] array) {

        int size = array.length;

        for (int indexTwo = 1; indexTwo < size; indexTwo++) {

            int comparedNum = array[indexTwo];
            int indexOne = indexTwo - 1;

            while (indexOne >= 0 && array[indexOne] > comparedNum) {

                array[indexOne + 1] = array[indexOne];
                indexOne = indexOne - 1;
            }
            array[indexOne + 1] = comparedNum;
        }
    }
}
