package sorting;

import java.util.Random;

public class RandomNumbersArray {
    static int[] createRandomNums(int count) {
        int[] nums = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            nums[i] = random.nextInt(1000);
        }

        return nums;
    }
}
