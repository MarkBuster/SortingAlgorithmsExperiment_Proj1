import java.io.File;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        TimeManager timeManager = new TimeManager();
        File file = new File("data/inputData.txt");

        int[][][] arrayData = dataManager.generateData(4, 2, 14, file);

        // You can use this to print the array data.
        //dataManager.printData(arrayData);

        // TODO: do we need .clone() to avoid changing the original array, or am I overthinking it?
        // TODO: having to make individual methods for every sorting algorithm feels repetitive,
        //       unfortunately, I haven't been able to find a way to call methods in separate classes in a for loop, does someone else know?

        timeManager.writeRadixTime(arrayData.clone());
        //timeManager.writeInsertionTime(arrayData.clone());
        //timeManager.writeMergeTime(arrayData.clone());

        //timeManager.writeBubbleTime(arrayData.clone());
        //timeManager.writeHeapTime(arrayData.clone());
        //timeManager.writeBucketTime(arrayData.clone());

        //timeManager.writeSelectionTime(arrayData.clone());
        //timeManager.writeCountTime(arrayData.clone());
        //timeManager.writeShellTime(arrayData.clone());

        //timeManager.writeQuickRandomTime(arrayData.clone());
        //timeManager.writeQuickFirstTime(arrayData.clone());
        //timeManager.writeQuickMedianTime(arrayData.clone());
    }
}
