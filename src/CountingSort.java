import java.util.Arrays;

public class CountingSort {

    public void countingSort(int[] array) {
        
        if (array.length == 0) {
            return;
        }
        int max = Arrays.stream(array).max().getAsInt();
        int[] count = new int[max + 1];
        
        for (int number : array) {
            count[number]++;
        }
        int arrayIndex = 0;
        
        for (int i = 0; i < count.length; i++) {
            
            while (count[i] > 0) {
                
                array[arrayIndex++] = i;
                count[i]--;
            }
        }
    }
}