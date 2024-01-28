public class HeapSort {

    public void heapSort(int[] array) {

        int length = array.length;

        // Build max heap
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }// end for i

        // Extract elements from heap one by one
        for (int i = length - 1; i > 0; i--) {
            // Swap root (max element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap where i is length
            heapify(array, i, 0);
        }// end for i
    }// end heapSort()

    void heapify(int[] array, int length, int index) {

        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }// end if

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }// end if

        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;

            heapify(array, length, largest);
        }// end if
    }// end heapify()

}// end class
