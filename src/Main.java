import java.io.File;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        TimeManager timeManager = new TimeManager();
        File file = new File("data/inputData.txt");

        // 3D-array:
        // top-level lists array sizes (4, 8, 16, etc.),
        // middle-level lists sorting order (random, reverse, partial, etc.),
        // bottom-level lists the arrays themselves (to be inputted into the sorting methods).
        int[][][] arrayData = dataManager.generateData(5, 2, 14, file);

        // You can use this to print the array data.
        dataManager.printData(arrayData);

        // Writes the time taken by each algorithm.
        timeManager.writeAllTimes(arrayData);
    }
}
