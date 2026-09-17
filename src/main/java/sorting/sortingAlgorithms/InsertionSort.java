package sorting.sortingAlgorithms;

public class InsertionSort {
    static void insertionSort(int[] nums) {

        for(int i = 0; i < nums.length; i++) {

            int value = nums[i];
            for(int j = i - 1; j >= 0 && nums[j] > value; j--) {
                if(nums[j] > value) {
                    nums[j + 1] = nums[j];
                    nums[j] = value;
                }

            }
        }
    };
}
