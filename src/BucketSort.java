import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the Bucket Sort class. The Bucket Sort algorithm is a sorting algorithm
 * that works by distributing the elements of an array into a number of buckets and then sorting each bucket
 * individually. It then returns the sorted elements in each bucket back into the array in a sorted order. Bucket
 * sort algorithms have a time complexity of O(N^2) and is not a stable algorithm.
 */
public class BucketSort {
    /**
     * This bucketSort utilizes more buckets that typical in an effort for a faster time complexity but makes a
     * sacrifice in memory to do so. It uses n amount of buckets. It shuffles the elements of the input array
     * into the corresponding ordered buckets then back into the array sorted. The empirical results of this algorithm
     * matched the theoretical results very closely but while it still may be considered O(n^2), it
     * is faster than some notoriously slower algorithms like Bubble sort.
     * @param array array if integers
     */
    public void bucketSort(int[] array) {

        int numberOfBuckets = array.length;
        int maxValue = Integer.MIN_VALUE;

        // Find the max value.
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        // Create a 2D List and initialize the contents.
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Add values to the bucket.
        for (int value : array) {
            int bucketIndex = (int)((double) value / maxValue * (numberOfBuckets - 1));
            buckets.get(bucketIndex).add(value);
        }

        // Sort the values in each bucket.
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Assign the sorted values to the original array.
        int index = 0;
        for (List<Integer> bucket : buckets){
            for (int value : bucket){
                array[index] = value;
                index++;
            }
        }
    }
}
