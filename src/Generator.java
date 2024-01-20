import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    public int[] generate(int arraySize, int minValue, int maxValue) {

        int[] output = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            output[index] = ThreadLocalRandom.current().nextInt((maxValue - minValue) + 1) + minValue;
        }

        return output;
    }

    public void partialOrder(int[] input, double percentOrdered) {

        // Setup length, sorted length, and indexes to use.
        int length = input.length;
        int sortedLength = (int)(length * percentOrdered);
        ArrayList<Integer> indexes = new ArrayList<>();

        // Add indexes to the list.
        for (int index = 0; index < input.length; index++) {
            indexes.add(index);
        }
        // Shuffle the indexes (allows for unique random numbers when read linearly).
        Collections.shuffle(indexes);
        // Arraylist containing values to be sorted.
        ArrayList<Integer> sorted = new ArrayList<>();

        if (length > sortedLength + 1) {
            indexes.subList(sortedLength + 1, length).clear();
        }

        // Add the values using the unique random indexes.
        for (int index = 0; index < sortedLength; index++) {
            sorted.add(input[indexes.get(index)]);
        }
        // Sort the values.
        Collections.sort(sorted);
        Collections.sort(indexes);

        // Put the values back into the original list.
        for (int index = 0; index < sortedLength; index++) {
            input[indexes.get(index)] = sorted.get(index);
        }
    }
}