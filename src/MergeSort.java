/**
 * The MergeSort class provides a method to perform merge sort on an array of integers.
 * Merge sort is a divide-and-conquer algorithm that recursively divides the array into two halves,
 * sorts them, and then merges the sorted halves.
 * Merge sort have is O(n log n) for all cases.
 * The empirical results reflex theoretical results where the average ms
 * stay consistent across the variations of input configuration.
 */
public class MergeSort {

    /**
     * Sorts the given array using the merge sort algorithm.
     *
     * @param array The array of integers to be sorted.
     */
    public void mergeSort(int[] array) {

        int length = array.length;
        
        if (length > 1) {
            
            int mid = array.length / 2;

            int[] left = new int[mid];
            int[] right = new int[length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     *
     * @param array The array to be merged into.
     * @param left  The left sorted subarray.
     * @param right The right sorted subarray.
     */
    private void merge(int[] array, int[] left, int[] right) {

        int leftIdx = 0;
        int rightIdx = 0;
        int arrayInx = 0;

        // comparing left and right
        while (leftIdx < left.length && rightIdx < right.length) {

            if (left[leftIdx] < right[rightIdx]) {
                array[leftIdx] = left[leftIdx];
                leftIdx++;

            } else {
                array[rightIdx] = right[rightIdx];
                rightIdx++;
            }
            arrayInx++;
        }
        // copy remaining left
        while (leftIdx < left.length) {

            array[arrayInx] = left[leftIdx];
            leftIdx++;
            arrayInx++;
        }
        // copy remaining right
        while (rightIdx < right.length) {

            array[arrayInx] = right[rightIdx];
            rightIdx++;
            arrayInx++;
        }
    }
}
