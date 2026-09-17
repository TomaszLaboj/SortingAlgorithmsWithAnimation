package sorting;

import sorting.utils.ShuffledNumbers;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsertionSortWithAnimation extends Frame implements Runnable {
    static int[] heights;
    int checkedIndex;
    boolean sorted = false;
    Color darkGreen = new Color(Integer.parseInt("2B9348", 16));
    Thread t1;
    Image offscreenImage;
    Graphics offscreenGraphics;

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
        if (offscreenImage == null || offscreenImage.getWidth(null) != getWidth()
                || offscreenImage.getHeight(null) != getHeight()) {
            offscreenImage = createImage(getWidth(), getHeight());

            offscreenGraphics = offscreenImage.getGraphics();
        }
        offscreenGraphics.setColor(getBackground());
        offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());
        drawGraph(offscreenGraphics);

        g.drawImage(offscreenImage, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public void drawGraph(Graphics g) {
        int gap = 1;
        int width = 14;
        int x = 20;
        int bottom = 500;
        int index = 0;
        for(int height : heights) {
            if (index == checkedIndex) {
                g.setColor(Color.RED);
            } else if (sorted) {
                g.setColor(darkGreen);
            } else {
                g.setColor(Color.black);
            }
            g.fillRect(x, bottom - height, width, height);
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
        appwin.setTitle("Insertion Sort");
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

