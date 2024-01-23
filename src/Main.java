import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        File file = new File("data/inputData.txt");

        // You can use smaller values to make arrays easier to read!
        int[][][] inputData = dataManager.generateData(3, 1, 1, file);

        // Feel free to use smaller sizes temporarily to make the data easier to read.
//        File file = new File("data/inputData.txt");
//        int[][][] inputData = dataManager.generateData(4, 1, 1, file);
//
//        System.out.println(Arrays.deepToString(inputData));
        String filePath = "data/inputData.txt";
        List<ArrayList<Integer>> radixData = dataManager.readFile(filePath);

        // TODO: time sorting algorithm and out put to file.
        RadixSort sort = new RadixSort();

        for (ArrayList<Integer> data: radixData) {
            System.out.println(data);
            sort.radixSort(data);
            System.out.println("Sorted: " + data);
        }

        List<ArrayList<Integer>> insertionData = dataManager.readFile(filePath);
        InsertionSort insert = new InsertionSort();
        System.out.println("\nInsertionSort");
        for (ArrayList<Integer> data: insertionData) {
            System.out.println(data);
            insert.insertionSort(data);
            System.out.println("Sorted: " + data);
        }

        List<ArrayList<Integer>> mergeData = dataManager.readFile(filePath);
        MergeSort mergeSort = new MergeSort();
        System.out.println("\nMergeSort");
        for (ArrayList<Integer> data: mergeData) {
            System.out.println(data);
            mergeSort.mergeSort(data);
            System.out.println("Sorted: " + data);
        }

    }
}
