public class QuickSortMedian {

    private int median(int[] input, int start, int end) {

        int middle = (start + end) / 2;
        int biggest = Math.max(start, Math.max(middle, end));

        if (biggest == start) {
            return Math.max(middle, end);
        }
        if (biggest == end) {
            return Math.max(start, middle);
        }
        return  Math.max(start, end);
    }

    private void swap(int[] input, int first, int second) {

        int temporary = input[first];
        input[first] = input[second];
        input[second] = temporary;
    }

    private int partition(int[] input, int start, int end) {

        int median = median(input, start, end);
        int pivot = input[median];
        int left = start;

        swap(input, median, end);

        for (int right = start; right < end; right++) {

            if (input[right] < pivot) {

                swap(input, right, left);
                left++;
            }
        }
        swap(input, end, left);

        return left;
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