import java.util.ArrayList;

public class MergeSort {
    public void mergeSort(ArrayList<Integer> array) {
        if (array.size() > 1) {
            int mid = array.size() / 2;

            ArrayList<Integer> left = new ArrayList<>(array.subList(0, mid));
            ArrayList<Integer> right = new ArrayList<>(array.subList(mid, array.size()));

            mergeSort(left);
            mergeSort(right);

            merge(array,left,right);
        }
    }

    public void merge(ArrayList<Integer> array, ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftIdx = 0;
        int rightIdx = 0;
        int arrayInx = 0;

        // comparing left and right
        while (leftIdx < left.size() && rightIdx < right.size()) {
            if (left.get(leftIdx) <= right.get(rightIdx)) {
                array.set(leftIdx, left.get(leftIdx));
                leftIdx++;
            } else {
                array.set(rightIdx, right.get(rightIdx));
                rightIdx++;
            }
            arrayInx++;
        }

        // copy remaining left
        while (leftIdx < left.size()) {
            array.set(arrayInx, left.get(leftIdx));
            leftIdx++;
        }

        // copy remaining right
        while (rightIdx < right.size()) {
            array.set(arrayInx, right.get(rightIdx));
            rightIdx++;
        }
    }
}
