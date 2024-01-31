/**
 * Bubble sort compares adjacent elements and swaps them if they are in the wrong order. The algorithm continues
 * to pass through the list until no more swaps are needed, indicating that the list is sorted. During this
 * process, if two elements have equal keys and are in adjacent positions, they will not be swapped, thereby
 * remaining a stable algorithm. Bubble sort is not the best algorithm to used with large data sets because of
 * its time complexity rating of O(n^2). It is an in place sorting algorithm, so it is memory efficient.
 */
public class BubbleSort {
    /**
     * Bubble sort takes in an array and sorts the array in place. The empirical results of this algorithm perfectly
     * the theoretical results.
     * @param array array of integers.
     */
    public void bubbleSort(int[] array) {

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * This method prints an int array that is given to it.
     * @param array array if integers.
     */
    public void print(int[] array) {

        int length = array.length;

        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
