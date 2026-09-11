package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffledNumbers {
    List<Integer> orderedList = new ArrayList<>();
    public List<Integer> shuffledList = new ArrayList<>();

    public ShuffledNumbers(int size) {
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

    public List<Integer> getOrderedList() {
        return orderedList;
    }

    public List<Integer> getShuffledList() {
        return shuffledList;
    }
}

