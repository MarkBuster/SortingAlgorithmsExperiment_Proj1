import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    File file = new File("data/inputDataTest.txt");
    DataManager dataManager = new DataManager();
    int[][][] data = dataManager.generateData(4, 2, 3, file);
    int[] sortedData1 = data[0][2].clone();
    int[] sortedData2 = data[1][2].clone();
    int[] sortedData3 = data[2][2].clone();

    @Test
    void quickSortFirstTest() {

        QuickSortFirst quickSortFirst = new QuickSortFirst();

        assertArrayEquals(sortedData1, quickSortFirst.quickSort(data[0][0]));
        assertArrayEquals(sortedData1, quickSortFirst.quickSort(data[0][1]));
        assertArrayEquals(sortedData1, quickSortFirst.quickSort(data[0][2]));
        assertArrayEquals(sortedData1, quickSortFirst.quickSort(data[0][3]));
        assertArrayEquals(sortedData1, quickSortFirst.quickSort(data[0][4]));
    }

    @Test
    void quickSortMedianTest() {

        QuickSortMedian quickSortMedian = new QuickSortMedian();

        assertArrayEquals(sortedData2, quickSortMedian.quickSort(data[1][0]));
        assertArrayEquals(sortedData2, quickSortMedian.quickSort(data[1][1]));
        assertArrayEquals(sortedData2, quickSortMedian.quickSort(data[1][2]));
        assertArrayEquals(sortedData2, quickSortMedian.quickSort(data[1][3]));
        assertArrayEquals(sortedData2, quickSortMedian.quickSort(data[1][4]));
    }

    @Test
    void quickSortRandomTest() {

        QuickSortRandom quickSortRandom = new QuickSortRandom();

        assertArrayEquals(sortedData3, quickSortRandom.quickSort(data[2][0]));
        assertArrayEquals(sortedData3, quickSortRandom.quickSort(data[2][1]));
        assertArrayEquals(sortedData3, quickSortRandom.quickSort(data[2][2]));
        assertArrayEquals(sortedData3, quickSortRandom.quickSort(data[2][3]));
        assertArrayEquals(sortedData3, quickSortRandom.quickSort(data[2][4]));
    }
}
