import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class DataManager {

    File file;

    public int[][][] generateData(int dataSize, int sizeMultiplier, int numberOfArrays, File inputFile) {

        file = inputFile;
        // TODO: the following code block can be de-commented once file reading is complete.
        //if (file.isFile() && !file.isDirectory()) {
        //    return readFile();
        //}

        // 3D-array:
        // top-level lists array sizes (4, 8, 16, etc.),
        // middle-level lists sorting order (random, reverse, partial, etc.),
        // bottom-level lists the arrays themselves (to be inputted into the sorting methods).
        int[][][] inputData = new int[numberOfArrays][5][];

        for (int sizeIndex = 0; sizeIndex < inputData.length; sizeIndex++) {

            int[] elements = generateArray(dataSize, 0, 40000);

            for (int sortIndex = 0; sortIndex < inputData[0].length; sortIndex++) {

                inputData[sizeIndex][sortIndex] = elements.clone();
            }
            Arrays.sort(inputData[sizeIndex][1]);

            // Reverse the array elements
            for (int left = 0, right = inputData[sizeIndex][1].length - 1; left < right; left++, right--) {

                int temp = inputData[sizeIndex][1][left];
                inputData[sizeIndex][1][left] = inputData[sizeIndex][1][right];
                inputData[sizeIndex][1][right] = temp;
            }
            Arrays.sort(inputData[sizeIndex][2]);
            partialOrder(inputData[sizeIndex][3], 0.5);
            partialOrder(inputData[sizeIndex][4], 0.75);

            dataSize *= sizeMultiplier;
        }
        try {
            writeFile(inputData);
        } catch (IOException ioException) {
            System.out.println("Could not write to file. Check if directory is correct.");
        }
        return inputData;
    }

    public int[] generateArray(int arraySize, int minValue, int maxValue) {

        int[] output = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            output[index] = ThreadLocalRandom.current().nextInt((maxValue - minValue) + 1) + minValue;
        }

        return output;
    }

    public void partialOrder(int[] inputData, double percentOrdered) {

        // Setup length, sorted length, and indexes to use.
        int length = inputData.length;
        int sortedLength = (int)(length * percentOrdered);
        ArrayList<Integer> indexes = new ArrayList<>();

        // Add indexes to the list.
        for (int index = 0; index < length; index++) {
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
            sorted.add(inputData[indexes.get(index)]);
        }
        // Sort the values.
        Collections.sort(sorted);
        Collections.sort(indexes);

        // Put the values back into the original list.
        for (int index = 0; index < sortedLength; index++) {
            inputData[indexes.get(index)] = sorted.get(index);
        }
    }

    public void writeFile(int[][][] inputData) throws IOException {

        FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8);

        for (int[][] inputSize : inputData) {

            for (int[] inputSort : inputSize) {

                fileWriter.write(String.valueOf(inputSort[0]));

                for (int arrayIndex = 1; arrayIndex < inputData[0][0].length; arrayIndex++) {
                    fileWriter.write(", " + inputSort[arrayIndex]);
                }
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
    }

    public int[][][] readFile() {

        // TODO: read the text file containing the arrays (1 array per line).

        return null;
    }
}