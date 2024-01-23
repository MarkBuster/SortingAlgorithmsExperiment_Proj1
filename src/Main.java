import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();
        File file = new File("data/inputData.txt");

        // You can use smaller values to make arrays easier to read!
        int[][][] inputData = dataManager.generateData(3, 1, 1, file);

        System.out.println(Arrays.deepToString(inputData));
    }
}
