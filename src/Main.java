import java.util.Arrays;

public class Main {

    // TODO: generate random arrays (store?), run algorithms with them, store results.

    public static void main(String[] args) {

        // Array generator.
        Generator generator = new Generator();

        // 3D-array:
        // top-level lists array sizes (4, 8, 16, etc.),
        // middle-level lists sorting order (random, reverse, partial, etc.),
        // bottom-level lists the arrays themselves (to be inputted into the sorting methods).
        int[][][] input = new int[14][5][];
        int size = 4;

        for (int sizeIndex = 0; sizeIndex < input.length; sizeIndex++) {

            for (int sortIndex = 0; sortIndex < input[0].length; sortIndex++) {

                input[sizeIndex][sortIndex] = generator.generate(size, 0, 40000);
            }

            Arrays.sort(input[sizeIndex][1]);

            // Reverse the array elements
            for (int left = 0, right = input[sizeIndex][1].length - 1; left < right; left++, right--) {

                int temp = input[sizeIndex][1][left];
                input[sizeIndex][1][left] = input[sizeIndex][1][right];
                input[sizeIndex][1][right] = temp;
            }
            Arrays.sort(input[sizeIndex][2]);
            generator.partialOrder(input[sizeIndex][3], 0.5);
            generator.partialOrder(input[sizeIndex][4], 0.75);

            size *= 2;
        }
    }
}
