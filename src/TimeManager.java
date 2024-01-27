import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TimeManager {

    public void writeAllTimes(int[][][] input) {

        // TODO: add methods for timing the other sorting algorithms.

        // Aaron
        writeQuickFirstTime(input.clone());
        writeQuickMedianTime(input.clone());
        writeQuickRandomTime(input.clone());

        // Mark
        writeBubbleTime(input.clone());
        writeBucketTime(input.clone());
        //writeHeapTime(input.clone());

        // Niki
        writeMergeTime(input.clone());
        writeInsertionTime(input.clone());
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

    private void writeMergeTime(int[][][] input) {

        File timeFile = new File("data/mergeTime.txt");
        MergeSort mergeSort = new MergeSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    mergeSort.mergeSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    private void writeInsertionTime(int[][][] input) {

        File timeFile = new File("data/insertionTime.txt");
        InsertionSort insertionSort = new InsertionSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    insertionSort.insertionSort(array);
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

    public void writeBubbleTime(int[][][] input) {

        File timeFile = new File("data/bubbleTime.txt");
        BubbleSort bubbleSort = new BubbleSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    bubbleSort.bubbleSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeBucketTime(int[][][] input) {

        File timeFile = new File("data/bucketTime.txt");
        BucketSort bucketSort = new BucketSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    bucketSort.bucketSort(array);
                    long endTime = System.nanoTime();

                    writer.write(endTime - startTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }
}