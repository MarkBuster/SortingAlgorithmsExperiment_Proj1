public class BubbleSort {

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

    public void print(int[] array) {

        int length = array.length;

        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}