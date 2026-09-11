package sorting;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertionSortWithAnimation extends Frame implements Runnable {
    static int[] heights;
    int checkedIndex;
    Thread t1;
    boolean sorted = false;

    public InsertionSortWithAnimation() {
        t1 = new Thread(this);
        t1.start();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        int gap = 1;
        int width = 14;
        int x = 20;
        int bottom = 500;
        int index = 0;
        for(int height : heights) {
            if (sorted) {
                g.setColor(Color.getHSBColor(0.33f, 1.0f, 0.39f));
                g.fillRect(x, bottom - height, width, height);
            } else if (index == checkedIndex) {
                g.setColor(Color.red);
                g.fillRect(x, bottom - height, width, height);
            } else {
                g.setColor(Color.black);
                g.fillRect(x, bottom - height, width, height);
            }
            x += width + gap;
            index++;
        }
    }

    @Override
    public void run() {
        try {
            insertionSort(heights);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ShuffledNumbers shuffledNumbers = new ShuffledNumbers(100);
        heights = shuffledNumbers.getShuffledList().stream().mapToInt(Integer::intValue).toArray();

        InsertionSortWithAnimation appwin = new InsertionSortWithAnimation();
        appwin.setSize(new Dimension(1600, 600));
        appwin.setTitle("Drawing Chart");
        appwin.setVisible(true);
    }

    void insertionSort(int[] nums) throws InterruptedException {
        sorted = false;
        for(int i = 0; i < nums.length; i++) {
            checkedIndex = i;
            int value = nums[i];
            for(int j = i - 1; j >= 0 && nums[j] > value; j--) {
                if(nums[j] > value) {
                    nums[j + 1] = nums[j];
                    nums[j] = value;
                }
                Thread.sleep(5);
                repaint();
            }
        }
        sorted = true;
    }
}

