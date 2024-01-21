import java.io.File;
import java.util.Arrays;

public class Main {

    // TODO: generate random arrays (store?), run algorithms with them, store results.

    public static void main(String[] args) {

        DataManager dataManager = new DataManager();

        // Feel free to use smaller sizes temporarily to make the data easier to read.
        File file = new File("data/inputData.txt");
        int[][][] inputData = dataManager.generateData(3, 1, 3, file);

        System.out.println(Arrays.deepToString(inputData));
    }
}
