import java.util.ArrayList;
import java.util.Collections;

public class CountingSort {

    public void countingSort(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return;
        }
        int max = Collections.max(arr);
        int[] count = new int[max + 1];
        for (int number : arr) {
            count[number]++;
        }
        int arrIndex = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr.set(arrIndex++, i);
                count[i]--;
            }
        }
    }
}