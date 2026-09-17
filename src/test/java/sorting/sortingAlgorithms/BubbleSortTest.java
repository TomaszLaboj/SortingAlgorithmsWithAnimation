package sorting.sortingAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubbleSortSortsNumbersCorrectly() {
        int[] nums1 = {5, 4, 7, 0, 11, 23, 8, 1, 2, 10 };
        int[] sortedNums1 = {0, 1, 2, 4, 5, 7, 8, 10, 11, 23 };
        assertArrayEquals(sortedNums1, BubbleSort.bubbleSort(nums1));
    }

}