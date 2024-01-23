import java.util.ArrayList;

public class RadixSort {

    // get max value in the list
    private static int getMax(ArrayList<Integer> array) {
        int max = array.getFirst();
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // sort the digit from lest significant digit to most significant
    private void countingSort(ArrayList<Integer> array, int exp) {
        int n = array.size();
        ArrayList<Integer> output = new ArrayList<>(n);
        int[] count = new int[10];

        // Initialize count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array.get(i) / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output.add(0);
        }
        for (int i = n - 1; i >= 0; i--) {
            output.set(count[(array.get(i) / exp) % 10] - 1, array.get(i));
            count[(array.get(i) / exp) % 10]--;
        }

        // Copy the output array to array[], so that array[] contains sorted numbers according to current digit
        for (int i = 0; i < n; i++) {
            array.set(i, output.get(i));
        }
    }

    public void radixSort(ArrayList<Integer> array) {
        int max = getMax(array);

        //increment by x10
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }
}
