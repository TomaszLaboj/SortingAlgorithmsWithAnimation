package sorting.sortingAlgorithms;

public class SelectionSort {

   static int[] selectionSort(int[] nums) {
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
       return nums;
   }



}
