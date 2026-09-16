package sorting;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class BubbleSortWithAnimation extends Frame implements Runnable {
    static int[] heights;
    int checkedIndex;
    boolean sorted = false;
    Color darkGreen = new Color(Integer.parseInt("2B9348", 16));
    Thread t1;
    Image offscreenImage;
    Graphics offscreenGraphics;

    public BubbleSortWithAnimation() {
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
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void run() {
        try {
            bubbleSort(heights);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ShuffledNumbers shuffledNumbers = new ShuffledNumbers(100);

        heights = shuffledNumbers.getShuffledList().stream().mapToInt(Integer::intValue).toArray();
        BubbleSortWithAnimation appwin = new BubbleSortWithAnimation();

        appwin.setSize(new Dimension(1600, 600));
        appwin.setTitle("Bubble Sort");
        appwin.setVisible(true);
    }

    void bubbleSort(int[] nums) throws InterruptedException {
        sorted = false;
        int lastIndex = nums.length - 1;

        while(lastIndex >= 1) {
            for (int i = 0; i < lastIndex; i++) {
                checkedIndex = i;
                if(nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
                Thread.sleep(5);
                repaint();
            }
            lastIndex--;
        }
        sorted = true;
    }
}

