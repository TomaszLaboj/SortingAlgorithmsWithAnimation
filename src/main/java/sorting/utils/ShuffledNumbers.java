package sorting.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffledNumbers {
    public List<Integer> shuffledList = new ArrayList<>();

    public ShuffledNumbers(int size) {
        List<Integer> orderedList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            orderedList.add(i);
        }
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            Integer randomPosition = orderedList.get(rand.nextInt(orderedList.size()));
            orderedList.remove(randomPosition);
            shuffledList.add(randomPosition);
        }
    }

    public List<Integer> getShuffledList() {
        return shuffledList;
    }
}

