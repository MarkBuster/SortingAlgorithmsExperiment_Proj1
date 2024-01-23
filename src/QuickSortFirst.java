public class QuickSortFirst {

    private void swap(int[] input, int first, int second) {

        int temporary = input[first];
        input[first] = input[second];
        input[second] = temporary;
    }

    private int partition(int[] input, int start, int end) {

        int pivot = input[start];
        int right = end;

        for (int left = end; left > start; left--) {

            if (input[left] > pivot) {

                swap(input, left, right--);
            }
        }
        swap(input, start, right);

        return right;
    }

    private void quickSort(int[] input, int start, int end) {

        if (start < end) {

            int partitionIndex = partition(input, start, end);

            quickSort(input, start, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, end);
        }
    }

    public void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }
}