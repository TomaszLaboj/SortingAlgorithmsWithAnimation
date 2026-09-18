package sorting.sortingAlgorithms;

public class MergeSort {
    static void mergeSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int length = nums.length;
        int midIndex = length / 2;
        int[] left = new int[midIndex];
        int[] right = new int[length - midIndex];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }

        for (int i = midIndex; i < nums.length; i++) {

            right[i - midIndex] = nums[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, nums);
    }


    static void merge(int[] left, int[] right, int[] original) {
        int totalLength = left.length + right.length;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < totalLength; i++) {
            if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
                original[i] = left[leftIndex];
                leftIndex++;
            } else {
                original[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }
}
