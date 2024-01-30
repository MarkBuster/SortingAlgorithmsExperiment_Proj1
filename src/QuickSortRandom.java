import java.util.concurrent.ThreadLocalRandom;

public class QuickSortRandom {

    private void swap(int[] input, int first, int second) {

        int temporary = input[first];
        input[first] = input[second];
        input[second] = temporary;
    }

    private void randomize(int[] input, int first, int last) {

        int pivot = ThreadLocalRandom.current().nextInt(last - first) + first;
        swap(input, pivot, last);
    }

    private int partition(int[] input, int start, int end) {

        randomize(input, start, end);
        int pivot = input[end];
        int left = start - 1;

        for (int right = start; right < end; right++) {

            if (input[right] < pivot) {

                left++;
                swap(input, left, right);
            }
        }
        swap(input, left + 1, end);

        return left + 1;
    }

    private void quickSort(int[] input, int start, int end) {

        if (start < end) {

            int partitionIndex = partition(input, start, end);

            quickSort(input, start, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, end);
        }
    }
    
    public int[] quickSort(int[] input) {

        quickSort(input, 0, input.length - 1);

        return input;
    }
}