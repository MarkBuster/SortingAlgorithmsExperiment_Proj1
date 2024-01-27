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

            while (end - start > 0) {

                int partition = partition(input, start, end);

                if ((partition - start) <= (end - partition)) {

                    quickSort(input, start, partition - 1);
                    start = partition + 1;
                } else {

                    quickSort(input, partition + 1, end);
                    end = partition - 1;
                }
            }
    }

    public void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }
}