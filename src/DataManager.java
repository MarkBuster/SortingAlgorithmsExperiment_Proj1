import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class DataManager {

    public int[][][] generateData(int dataSize, int sizeMultiplier, int numberOfArrays, File inputFile) {

        if (inputFile.isFile() && !inputFile.isDirectory()) {
            // TODO: handle broken file
            return readFile(inputFile, numberOfArrays);
        }

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
            writeDataFile(inputData, inputFile);
        } catch (IOException ioException) {
            System.out.println("Could not write to file. Check if directory is correct.");
        }
        return inputData;
    }

    public int[] generateArray(int arraySize, int minValue, int maxValue) {

        int[] output = new int[arraySize];

        for (int index = 0; index < arraySize; index++) {
            output[index] = ThreadLocalRandom.current().nextInt(minValue, maxValue);
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

        if (length > sortedLength) {
            indexes.subList(sortedLength, length).clear();
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

    public void printData(int[][][] inputData) {

        for (int[][] inputSize : inputData) {

            for (int[] inputSort : inputSize) {

                for (int element : inputSort) {
                    System.out.print(element + ",");
                }
                System.out.print("\n");
            }
        }
    }

    public void writeDataFile(int[][][] inputData, File inputFile) throws IOException {

        FileWriter fileWriter = new FileWriter(inputFile, StandardCharsets.UTF_8);

        for (int[][] inputSize : inputData) {

            for (int[] inputSort : inputSize) {

                for (int element : inputSort) {
                    fileWriter.write(element + ",");
                }
                fileWriter.write("\n");
            }
        }
        fileWriter.close();
    }

    public int[][][] readFile(File inputFile, int numberOfArrays) {

        int[][][] arrayData = new int[numberOfArrays][5][];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            String line;
            int arrayNumberIndex = 0;
            int arraySortIndex = 0;

            while ((line = reader.readLine()) != null) {

                if (arraySortIndex > 4) {
                    arraySortIndex = 0;
                    arrayNumberIndex++;
                }
                String[] array = line.split(",");
                arrayData[arrayNumberIndex][arraySortIndex] = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
                arraySortIndex++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayData;
    }
}