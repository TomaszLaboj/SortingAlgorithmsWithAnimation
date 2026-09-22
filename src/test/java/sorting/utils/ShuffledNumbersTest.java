package sorting.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShuffledNumbersTest {
    @Test
    void shuffledNumbersReturnCorrectLengthArray() {
        ShuffledNumbers shuffledNumbers = new ShuffledNumbers(10);
        assertEquals(10, shuffledNumbers.getShuffledList().size());
        shuffledNumbers = new ShuffledNumbers(20);
        assertEquals(20, shuffledNumbers.getShuffledList().size());
    }

    @Test
    void atLeastOneNumberIsShuffled() {
        ShuffledNumbers shuffledNumbers = new ShuffledNumbers(1000);
        int[] shuffledInts = shuffledNumbers.getShuffledList().stream().mapToInt(Integer::intValue).toArray();
        boolean numbersTheSame = true;
        for (int i = 0; i < 1000; i++) {
            if (shuffledInts[i] != i) {
                numbersTheSame = false;
                break;
            }
        }
        assertFalse(numbersTheSame);
    }


}