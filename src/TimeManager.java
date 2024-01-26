import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeManager {

    public void writeAllTimes(int[][][] input) {

        // TODO: add methods for timing the other sorting algorithms.

        // Aaron
        writeQuickFirstTime(input.clone());
        writeQuickMedianTime(input.clone());
        writeQuickRandomTime(input.clone());

        // Mark
        //writeBubbleTime(input.clone());
        //writeBucketTime(input.clone());
        //writeHeapTime(input.clone());

        // Niki
        //writeMergeTime(input.clone());
        //writeInsertionTime(input.clone());
        writeRadixTime(input.clone());

        // Ken
        //writeSelectionTime(input.clone());
        //writeShellTime(input.clone());
        //writeCountTime(input.clone());
    }

    // TODO: Use this as a template for the other sorting timers!
    public void writeQuickFirstTime(int[][][] input) {

        File timeFile = new File("data/quickFirstTime.txt");
        QuickSortFirst quickSortFirst = new QuickSortFirst();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    quickSortFirst.quickSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeQuickMedianTime(int[][][] input) {

        File timeFile = new File("data/quickMedianTime.txt");
        QuickSortMedian quickSortMedian = new QuickSortMedian();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    quickSortMedian.quickSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeQuickRandomTime(int[][][] input) {

        File timeFile = new File("data/quickRandomTime.txt");
        QuickSortRandom quickSortRandom = new QuickSortRandom();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    quickSortRandom.quickSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

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