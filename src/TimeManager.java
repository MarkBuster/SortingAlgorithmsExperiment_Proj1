import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TimeManager {

    public void writeAllTimes(int[][][] input) {

        // Aaron
        writeQuickFirstTime(input.clone());
        writeQuickMedianTime(input.clone());
        writeQuickRandomTime(input.clone());

        // Mark
        writeBubbleTime(input.clone());
        writeBucketTime(input.clone());
        writeHeapTime(input.clone());

        // Niki
        writeMergeTime(input.clone());
        writeInsertionTime(input.clone());
        writeRadixTime(input.clone());

        // Ken
        writeSelectionTime(input.clone());
        writeShellTime(input.clone());
        writeCountingTime(input.clone());
    }

    public void writeQuickFirstTime(int[][][] input) {

        File timeFile = new File("data/quickFirstTime.txt");
        QuickSortFirst quickSortFirst = new QuickSortFirst();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    quickSortFirst.quickSort(array);
                    long endTime = System.nanoTime();
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
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
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeHeapTime(int[][][] input) {

        File timeFile = new File("data/heapTime.txt");
        HeapSort heapSort = new HeapSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    heapSort.heapSort(array);
                    long endTime = System.nanoTime();
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeCountingTime(int[][][] input) {

        File timeFile = new File("data/countingTime.txt");
        CountingSort countingSort = new CountingSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    countingSort.countingSort(array);
                    long endTime = System.nanoTime();
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeShellTime(int[][][] input) {

        File timeFile = new File("data/shellTime.txt");
        ShellSort shellSort = new ShellSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    shellSort.shellSort(array);
                    long endTime = System.nanoTime();
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }

    public void writeSelectionTime(int[][][] input) {

        File timeFile = new File("data/selectionTime.txt");
        SelectionSort selectionSort = new SelectionSort();

        try (FileWriter writer = new FileWriter(timeFile)) {

            for (int[][] arrays : input) {

                for (int[] array : arrays) {

                    long startTime = System.nanoTime();
                    selectionSort.selectionSort(array);
                    long endTime = System.nanoTime();
                    double totalTime = (endTime - startTime) / 1000.0;

                    writer.write(totalTime + ",");
                }
                writer.write("\n");
            }
        } catch (IOException ioException) {

            throw new RuntimeException(ioException);
        }
    }
}