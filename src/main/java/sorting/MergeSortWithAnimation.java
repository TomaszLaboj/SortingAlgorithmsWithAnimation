package sorting;

import sorting.utils.ShuffledNumbers;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MergeSortWithAnimation extends BubbleSortWithAnimation {
    static int[] heights;
    int checkedIndex;
    boolean sorted = false;
    Color darkGreen = new Color(Integer.parseInt("2B9348", 16));
    Thread t1;
    Image offscreenImage;
    Graphics offscreenGraphics;

    public MergeSortWithAnimation() {
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
            mergeSort(heights);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ShuffledNumbers shuffledNumbers = new ShuffledNumbers(100);
        heights = shuffledNumbers.shuffledList.stream().mapToInt(Integer::intValue).toArray();

        MergeSortWithAnimation appwin = new MergeSortWithAnimation();
        appwin.setSize(new Dimension(1600, 600));
        appwin.setTitle("Merge Sort with animation");
        appwin.setVisible(true);
    }

    void mergeSort(int[] nums) throws InterruptedException {
        if (nums.length < 2) {
            return;
        }
        int length = nums.length;
        int midIndex = length / 2;
        int[] left = new int[midIndex];
        int[] right = new int[length - midIndex];

        for (int i = 0; i < left.length; i++) {
            checkedIndex = i;
            left[i] = nums[i];
            repaint();
            Thread.sleep(5);
        }

        for (int i = midIndex; i < nums.length; i++) {
            checkedIndex = i;

            right[i - midIndex] = nums[i];
            repaint();
            Thread.sleep(5);
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, nums);
    }


    void merge(int[] left, int[] right, int[] original) throws InterruptedException {
        int totalLength = left.length + right.length;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < totalLength; i++) {
            checkedIndex = i;
            if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
                original[i] = left[leftIndex];
                leftIndex++;
            } else {
                original[i] = right[rightIndex];
                rightIndex++;
            }
            repaint();
            Thread.sleep(5);
        }
        if (original.length == heights.length) {
            sorted = true;
        }
        repaint();
    }
}

