package sorting.sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    static int[] bubbleSort(int[] nums) {
        int lastIndex = nums.length - 1;
        while(lastIndex >= 1) {
            for (int i = 0; i < lastIndex; i++) {
                if(nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
            lastIndex--;
        }
        return nums;
    }
}
