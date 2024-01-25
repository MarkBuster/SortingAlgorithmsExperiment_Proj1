import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    int array[];

    public BucketSort(int array[]){
        this.array = array;
    }

    public void printArray() {
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //Print Buckets
    public void printBucket(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++){
            System.out.println("\nBucket#" + i + ":");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
        System.out.println();
    }

    // BucketSorting
    public void bucketSort() {
        int numberOfBuckets = array.length;//(int) Math.ceil(Math.sqrt(array.length));// shrinks the bucket count
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        ArrayList<Integer> [] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : array) {
            int bucketNumber = (int) Math.ceil(((float)value * numberOfBuckets)/(float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.println("\n\nPrinting buckets before sorting...");
            printBucket(buckets);

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        System.out.println("\n\nPrinting buckets after sorting...");
        printBucket(buckets);

        int index = 0;
        for(ArrayList<Integer> bucket: buckets){
            for(int value : bucket){
                array[index] = value;
                index++;
            }
        }


    }



}
