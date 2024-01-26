import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeManager {

    public void writeAllTimes(int[][][] input) {

        // TODO: add methods for timing the other sorting algorithms.

        // Niki
        writeRadixTime(input.clone());
        //writeInsertionTime(input.clone());
        //writeMergeTime(input.clone());

        // Mark
        //writeBubbleTime(input.clone());
        //writeHeapTime(input.clone());
        //writeBucketTime(input.clone());

        // Ken
        //writeSelectionTime(input.clone());
        //writeCountTime(input.clone());
        //writeShellTime(input.clone());

        // Aaron
        //writeQuickRandomTime(input.clone());
        //writeQuickFirstTime(input.clone());
        //writeQuickMedianTime(input.clone());
    }

    // TODO: Use this as a template for the other sorting timers!
    public void writeRadixTime(int[][][] input) {

        File timeFile = new File("data/radixTime.txt");
        RadixSort radixSort = new RadixSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    radixSort.radixSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    // TODO: convert merge and insertion sort to use array instead of ArrayList.
    private static void writeMergeTime(List<ArrayList<Integer>> mergeSortData) {

        MergeSort mergeSort = new MergeSort();
        System.out.println("MergeSort\n");
        File timeFile = new File("data/"+ "mergeTimeData" +".txt");

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
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private static void writeInsertionTime(List<ArrayList<Integer>> insertionSortData) {

        InsertionSort insert = new InsertionSort();
        System.out.println("InsertionSort\n");
        File timeFile = new File("data/"+ "insertionTimeData" +".txt");

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