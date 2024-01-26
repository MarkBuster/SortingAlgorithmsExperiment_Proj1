import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] array) {

        if (array.length > 1) {
            int mid = array.length / 2;

            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(left);
            mergeSort(right);

            merge(array,left,right);
        }
    }

    private void merge(int[] array, int[] left, int[] right) {
        int leftIdx = 0;
        int rightIdx = 0;
        int arrayInx = 0;

        // comparing left and right
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                array[arrayInx] = left[leftIdx];
                ++leftIdx;
            } else {
                array[arrayInx] = right[rightIdx];
                ++rightIdx;
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
