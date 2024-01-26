import java.util.ArrayList;

public class InsertionSort {
    public void insertionSort(int[] array) {
        int size = array.length;

        for (int indexTwo = 1; indexTwo < size; indexTwo++) {
            int comparedNum = array[indexTwo];
            int indexOne = indexTwo - 1;

            while (indexOne >= 0 && array[indexOne] > comparedNum) {
                array[indexOne + 1] = array[indexOne];
                indexOne--;
            }
            array[indexOne + 1] = comparedNum;
        }
    }
}
