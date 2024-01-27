public class MergeSort {

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
