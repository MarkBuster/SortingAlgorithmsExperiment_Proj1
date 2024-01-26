import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeManager {

    public void writeAllTimes(int[][][] input) {

        // TODO: add methods for timing the other sorting algorithms.

        // Niki
        writeRadixTime(input.clone());
        writeInsertionTime(input.clone());
        writeMergeTime(input.clone());

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
    private static void writeMergeTime(int[][][] mergeSortData) {

        MergeSort mergeSort = new MergeSort();
        File timeFile = new File("data/"+ "mergeTimeData" +".txt");

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : mergeSortData) {
                for (int[] array : arrays) {


                    long start = System.nanoTime();
                    mergeSort.mergeSort(array);
                    long end = System.nanoTime();
                    long elapsedTime = end - start;

                    writer.write(elapsedTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private static void writeInsertionTime(int[][][] insertionSortData) {

        InsertionSort insert = new InsertionSort();
        File timeFile = new File("data/"+ "insertionTimeData" +".txt");

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : insertionSortData) {

                for (int[] array : arrays) {

                    long start = System.nanoTime();
                    insert.insertionSort(array);
                    long end = System.nanoTime();
                    long elapsedTime = end - start;

                    writer.write(elapsedTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}