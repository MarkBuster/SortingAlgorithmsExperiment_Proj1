import java.io.File;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        TimeManager timeManager = new TimeManager();
        File file = new File("data/inputData.txt");

        int[][][] arrayData = dataManager.generateData(4, 2, 14, file);

        // You can use this to print the array data.
        dataManager.printData(arrayData);

        // Writes the time taken by each algorithm.
        timeManager.writeAllTimes(arrayData);
    }
}
