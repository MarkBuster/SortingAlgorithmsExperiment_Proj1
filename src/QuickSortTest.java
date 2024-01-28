import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    DataManager dataManager;

    @Test
    void quickSortFirstTest() {

        dataManager = new DataManager();
        QuickSortFirst quickSortFirst = new QuickSortFirst();

        // Base array (to maintain elements)
        int[] baseArray = dataManager.generateArray(32768, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Random array.
        int[] randomArray = baseArray.clone();

        // Forward ordered array.
        int[] forwardArray = baseArray.clone();
        Arrays.sort(forwardArray);

        // Reverse ordered array.
        int[] reverseArray = baseArray.clone();
        Arrays.sort(reverseArray);
        for (int left = 0, right = reverseArray.length - 1; left < right; left++, right--) {

            int temp = reverseArray[left];
            reverseArray[left] = reverseArray[right];
            reverseArray[right] = temp;
        }
        // 50% ordered array.
        int[] partial50Array = baseArray.clone();
        dataManager.partialOrder(partial50Array, 0.5);

        // 75% ordered array.
        int[] partial75Array = baseArray.clone();
        dataManager.partialOrder(partial75Array, 0.75);

        // Quick sort with first pivot each array.
        int[] randomArraySorted = randomArray.clone();
        quickSortFirst.quickSort(randomArraySorted);

        int[] forwardArraySorted = forwardArray.clone();
        quickSortFirst.quickSort(forwardArraySorted);

        int[] reverseArraySorted = reverseArray.clone();
        quickSortFirst.quickSort(reverseArraySorted);

        int[] partial50ArraySorted = partial50Array.clone();
        quickSortFirst.quickSort(partial50ArraySorted);
        
        int[] partial75ArraySorted = partial75Array.clone();
        quickSortFirst.quickSort(partial75ArraySorted);

        // Check if the arrays were sorted correctly.
        assertArrayEquals(forwardArray, randomArraySorted);
        assertArrayEquals(forwardArray, forwardArraySorted);
        assertArrayEquals(forwardArray, reverseArraySorted);
        assertArrayEquals(forwardArray, partial50ArraySorted);
        assertArrayEquals(forwardArray, partial75ArraySorted);
    }

    @Test
    void quickSortMedianTest() {

        dataManager = new DataManager();
        QuickSortMedian quickSortMedian = new QuickSortMedian();

        // Base array (to maintain elements)
        int[] baseArray = dataManager.generateArray(32768, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Random array.
        int[] randomArray = baseArray.clone();

        // Forward ordered array.
        int[] forwardArray = baseArray.clone();
        Arrays.sort(forwardArray);

        // Reverse ordered array.
        int[] reverseArray = baseArray.clone();
        Arrays.sort(reverseArray);
        for (int left = 0, right = reverseArray.length - 1; left < right; left++, right--) {

            int temp = reverseArray[left];
            reverseArray[left] = reverseArray[right];
            reverseArray[right] = temp;
        }
        // 50% ordered array.
        int[] partial50Array = baseArray.clone();
        dataManager.partialOrder(partial50Array, 0.5);

        // 75% ordered array.
        int[] partial75Array = baseArray.clone();
        dataManager.partialOrder(partial75Array, 0.75);

        // Quick sort with median pivot each array.
        int[] randomArraySorted = randomArray.clone();
        quickSortMedian.quickSort(randomArraySorted);

        int[] forwardArraySorted = forwardArray.clone();
        quickSortMedian.quickSort(forwardArraySorted);

        int[] reverseArraySorted = reverseArray.clone();
        quickSortMedian.quickSort(reverseArraySorted);

        int[] partial50ArraySorted = partial50Array.clone();
        quickSortMedian.quickSort(partial50ArraySorted);

        int[] partial75ArraySorted = partial75Array.clone();
        quickSortMedian.quickSort(partial75ArraySorted);

        // Check if the arrays were sorted correctly.
        assertArrayEquals(forwardArray, randomArraySorted);
        assertArrayEquals(forwardArray, forwardArraySorted);
        assertArrayEquals(forwardArray, reverseArraySorted);
        assertArrayEquals(forwardArray, partial50ArraySorted);
        assertArrayEquals(forwardArray, partial75ArraySorted);
    }

    @Test
    void quickSortRandomTest() {

        dataManager = new DataManager();
        QuickSortRandom quickSortRandom = new QuickSortRandom();

        // Base array (to maintain elements)
        int[] baseArray = dataManager.generateArray(32768, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Random array.
        int[] randomArray = baseArray.clone();

        // Forward ordered array.
        int[] forwardArray = baseArray.clone();
        Arrays.sort(forwardArray);

        // Reverse ordered array.
        int[] reverseArray = baseArray.clone();
        Arrays.sort(reverseArray);
        for (int left = 0, right = reverseArray.length - 1; left < right; left++, right--) {

            int temp = reverseArray[left];
            reverseArray[left] = reverseArray[right];
            reverseArray[right] = temp;
        }
        // 50% ordered array.
        int[] partial50Array = baseArray.clone();
        dataManager.partialOrder(partial50Array, 0.5);

        // 75% ordered array.
        int[] partial75Array = baseArray.clone();
        dataManager.partialOrder(partial75Array, 0.75);

        // Quick sort with random pivot each array.
        int[] randomArraySorted = randomArray.clone();
        quickSortRandom.quickSort(randomArraySorted);

        int[] forwardArraySorted = forwardArray.clone();
        quickSortRandom.quickSort(forwardArraySorted);

        int[] reverseArraySorted = reverseArray.clone();
        quickSortRandom.quickSort(reverseArraySorted);

        int[] partial50ArraySorted = partial50Array.clone();
        quickSortRandom.quickSort(partial50ArraySorted);

        int[] partial75ArraySorted = partial75Array.clone();
        quickSortRandom.quickSort(partial75ArraySorted);

        // Check if the arrays were sorted correctly.
        assertArrayEquals(forwardArray, randomArraySorted);
        assertArrayEquals(forwardArray, forwardArraySorted);
        assertArrayEquals(forwardArray, reverseArraySorted);
        assertArrayEquals(forwardArray, partial50ArraySorted);
        assertArrayEquals(forwardArray, partial75ArraySorted);
    }
}
