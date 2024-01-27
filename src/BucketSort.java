import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

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