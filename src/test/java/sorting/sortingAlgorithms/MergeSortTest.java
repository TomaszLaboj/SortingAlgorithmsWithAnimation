package sorting.sortingAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static sorting.sortingAlgorithms.MergeSort.mergeSort;

class MergeSortTest {

    @Test
    void mergeSortSortesNumbersCorrectly() {
        int[] nums1 = {5, 4, 7, 0, 11, 23, 8, 1, 2, 10 };
        int[] sortedNums1 = {0, 1, 2, 4, 5, 7, 8, 10, 11, 23 };
        mergeSort(nums1);
        assertArrayEquals(sortedNums1, nums1);
    }

    @Test
    void mergeSortSortsReversedNumbers() {
        int[] reversed = {5, 4, 3, 2, 1};
        int[] sorted = {1, 2, 3, 4, 5};
        mergeSort(reversed);
        assertArrayEquals(sorted, reversed);
    }
}