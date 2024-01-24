import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // TODO: generate random arrays (store?), run algorithms with them, store results.

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();


//         Feel free to use smaller sizes temporarily to make the data easier to read.
//        File file = new File("data/inputData.txt");
//        int[][][] inputData = dataManager.generateData(4, 1, 1, file);
//
//        System.out.println(Arrays.deepToString(inputData));
        String filePath = "data/inputData.txt";

        List<ArrayList<Integer>> radixData = dataManager.readFile(filePath);
        radixSort(radixData,"radixTimeData");

        List<ArrayList<Integer>> insertionData = dataManager.readFile(filePath);
        insertionSort(insertionData,"insertionTimeData");

        List<ArrayList<Integer>> mergeData = dataManager.readFile(filePath);
        mergeSort(mergeData,"mergeTimeData");

    }

    private static void mergeSort(List<ArrayList<Integer>> mergeSortData, String fileName) {
        MergeSort mergeSort = new MergeSort();
        System.out.println("MergeSort\n");
        File timeFile = new File("data/"+fileName+".txt");

        try (FileWriter writer = new FileWriter(timeFile)) {
            for (ArrayList<Integer> data : mergeSortData) {
                System.out.println(data);
                writer.write(data.toString());

                long start = System.nanoTime();
                mergeSort.mergeSort(data);
                long end = System.nanoTime();
                long elapsedTime = end - start;

                System.out.println("Sorted: " + data);
                System.out.println("Time taken: " + elapsedTime + " ms\n");
                writer.write("Time taken: " + elapsedTime + " ms\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void radixSort(List<ArrayList<Integer>> radixSortData, String fileName) {
        RadixSort sort = new RadixSort();
        System.out.println("RadixSort\n");
        File timeFile = new File("data/"+fileName+".txt");

        try (FileWriter writer = new FileWriter(timeFile)) {
            for (ArrayList<Integer> data : radixSortData) {
                System.out.println(data);
                writer.write(data.toString());

                long start = System.nanoTime();
                sort.radixSort(data);
                long end = System.nanoTime();
                long elapsedTime = end - start;

                System.out.println("Sorted: " + data);
                System.out.println("Time taken: " + elapsedTime + " ms\n");
                writer.write("Time taken: " + elapsedTime + " ms\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertionSort(List<ArrayList<Integer>> insertionSortData, String fileName) {
        InsertionSort insert = new InsertionSort();
        System.out.println("InsertionSort\n");
        File timeFile = new File("data/"+fileName+".txt");

        try (FileWriter writer = new FileWriter(timeFile)) {
            for (ArrayList<Integer> data : insertionSortData) {
                System.out.println(data);
                writer.write(data.toString());

                long start = System.nanoTime();
                insert.insertionSort(data);
                long end = System.nanoTime();
                long elapsedTime = end - start;

                System.out.println("Sorted: " + data);
                System.out.println("Time taken: " + elapsedTime + " ms\n");
                writer.write("Time taken: " + elapsedTime + " ms\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
