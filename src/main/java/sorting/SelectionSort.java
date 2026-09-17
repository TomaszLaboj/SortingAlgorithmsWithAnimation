package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5,3,2,3,7,6,4,6,7,7,22,3,5};
        System.out.println("Before " + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("After " + Arrays.toString(nums));

    }

   static void selectionSort(int[] nums) {
       int minIndex;

       for (int i = 0; i < nums.length; i++) {
           minIndex = i;

           for (int j = i; j < nums.length; j++) {
               if (nums[j] < nums[minIndex]) {
                   minIndex = j;
               }
           }
           int temp = nums[i];
           nums[i] = nums[minIndex];
           nums[minIndex] = temp;
       }
   };

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
