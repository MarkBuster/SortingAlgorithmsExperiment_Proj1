/**
 * The RadixSort class provides a method to perform radix sort on an array of integers.
 * Radix sort is a non-comparative sorting algorithm that works by distributing elements into buckets
 * according to their individual digits, from the least significant digit to the most significant digit.
 * Radix sort have liner time complexity O(nd).
 * The empirical results reflex theoretical results where the average ms
 * stay consistent across the variations of input configuration.
 */
public class RadixSort {

    /**
     * Finds the maximum value in the given array.
     *
     * @param array The array of integers.
     * @return The maximum value in the array.
     */
    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Performs counting sort on the array based on the specified digit position (exp).
     *
     * @param array The array of integers to be sorted.
     * @param exp   The position of the digit (power of 10).
     */
    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Initialize count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int j : array) {
            count[(j / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[(count[(array[i] / exp) % 10] - 1)] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to array[], so that array[] contains sorted numbers according to current digit
        System.arraycopy(output, 0, array, 0, n);
    }

    /**
     * Sorts the given array using the radix sort algorithm.
     *
     * @param array The array of integers to be sorted.
     */
    public void radixSort(int[] array) {
        int max = getMax(array);

        //increment by x10
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }
}
