import java.io.File;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        TimeManager timeManager = new TimeManager();
        File file = new File("data/inputData.txt");

        // 3D-array:
        // top-level lists array sizes (4, 8, 16, etc.),
        // middle-level lists sorting order (random, reverse, partial, etc.),
        // bottom-level lists the arrays themselves (to be inputted into the sorting methods).
        int[][][] arrayData = dataManager.generateData(5, 2, 14, file);

        // You can use this to print the array data.
//        dataManager.printData(arrayData);

        // Writes the time taken by each algorithm.
//        timeManager.writeAllTimes(arrayData);
        int[] testarray = {7,2,89,45,33,72,41,27,45,66,99,180,57,42,23};
        HeapSort hs = new HeapSort();
        hs.heapSort(testarray);
        for (int num : testarray) {
            System.out.print(num + " ");
        }
    }
}
