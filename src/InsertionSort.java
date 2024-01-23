import java.util.ArrayList;

public class InsertionSort {
    public void insertionSort(ArrayList<Integer> array) {
        int size = array.size();

        for (int indexTwo = 1; indexTwo < size; indexTwo++) {
            int comparedNum = array.get(indexTwo);
            int indexOne = indexTwo - 1;

            while (indexOne >= 0 && array.get(indexOne) > comparedNum) {
                array.set(indexOne + 1, array.get(indexOne));
                indexOne = indexOne - 1;
            }
            array.set(indexOne + 1, comparedNum);
        }
    }
}
