/**
 * The heap sort class enables the user to use the heapSort method to sort any data from an int array.
 * The class contains a method for heapsort and a helper method that is used in this sorting implementation
 * called heapify. HeapSort takes up little space as an in-place sorting algorithm that sorts integers in an
 * abstract data structure of a max-heap binary tree while all the data remains in one array. The time complexity for this
 * algorithm is O(nlogn). HeapSort is not a stable algorithm.
 */
public class HeapSort {
    /**
     * HeapSort takes in an array of integers, build a max-heap binary tree with an array, swaps values to the back
     * of array and heapifies to sort. The empirical results of this algorithm match the theoretical results
     * of O(nlogn). Two special cases were present with the randomly ordered and reverse oreded arrays which were
     * measurably slower that the rest with the largest data sets.
     *
     * @param array array of integers
     */
    public void heapSort(int[] array) {
        int length = array.length;

        // Build max heap
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // Extract elements from heap one by one
        for (int i = length - 1; i > 0; i--) {
            // Swap root (max element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap where i is length
            heapify(array, i, 0);
        }
    }

    /**
     * Heapify is a method that recursively swaps two index values depending on pre-programmed criteria.
     * @param array array of integers to make swaps on
     * @param length length variable
     * @param index index for array navigation
     */
    void heapify(int[] array, int length, int index) {

        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(array, length, largest);
        }
    }

}
