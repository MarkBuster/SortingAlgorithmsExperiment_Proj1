public class BubbleSort {
    public void bubbleSort(int array[]) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }// end if
            }// end for j
        }// end for i
    }// end bubbleSort

    public void printIt(int array[]) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }// end for i
        System.out.println();
    }// end printIt

}// end class
