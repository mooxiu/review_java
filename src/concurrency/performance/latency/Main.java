package concurrency.performance.latency;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static final String originalImage = "src/concurrency/performance/assets/many-flowers.jpg";
    public static final String outputImage = "src/concurrency/performance/assets/new-many-flowers.jpg";

    /*
        getting rgb values
     */
    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }

    public static int recoverRGB(int red, int green, int blue) {
        int rgb = 0;

        rgb |= red << 16;
        rgb |= green << 8;
        rgb |= blue;

        rgb |= 0xFF000000;
        return rgb;
    }

    public static boolean isGreyScale(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(green - blue) < 30 && Math.abs(blue - red) < 30 && red > 130 && green > 130 && blue > 130;
    }

    public static void setPixelRBG(BufferedImage myImage, int xAxis, int yAxis, int RGB) {
        myImage.getRaster().setDataElements(xAxis, yAxis, myImage.getColorModel().getDataElements(RGB, null));
    }


    public static void recolorPixel(BufferedImage from, BufferedImage to, int xAxis, int yAxis) {
        int fromRGB = from.getRGB(xAxis, yAxis);

        int oldR = getRed(fromRGB);
        int oldG = getGreen(fromRGB);
        int oldB = getBlue(fromRGB);

        int newR = oldR;
        int newG = oldG;
        int newB = oldB;

        if (isGreyScale(oldR, oldG, oldB)) {
            newR = Math.min(oldR + 15, 255);
            newG = Math.max(oldG - 80, 0);
            newB = Math.max(oldB - 2, 0);
        }

        int newRGB = recoverRGB(newR, newG, newB);


        setPixelRBG(to, xAxis, yAxis, newRGB);
//        System.out.println("original rbg: "
//                + String.join(" ", String.valueOf(oldR), String.valueOf(oldR), String.valueOf(oldB)));
//        System.out.println("new rbg: "
//                + String.join(" ", String.valueOf(newR), String.valueOf(newG), String.valueOf(newB)));
    }

    public static void recolorImage(BufferedImage from, BufferedImage to,
                                    int leftCorner, int topCorner,
                                    int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < from.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < from.getHeight(); y++) {
                recolorPixel(from, to, x, y);
            }
        }
    }

    public static void recolorThreaded(BufferedImage from, BufferedImage to) {
        recolorImage(from, to, 0, 0, from.getWidth(), from.getHeight());
    }

    public static void recolorMultiThreaded(BufferedImage from, BufferedImage to, int ThreadNum) {
        List<Thread> threads = new ArrayList<>();
        int width = from.getWidth();
        int height = from.getHeight()/ThreadNum;

        for (int i = 0; i < ThreadNum; i++) {
            final int no = i;

            threads.add(new Thread(new Runnable() {
                final int leftCorner = 0;
                final int topCorner = height * no;

                @Override
                public void run() {
                    recolorImage(from, to, leftCorner, topCorner, width, height);
                }
            }));
        }

        for (var thread: threads) {
            thread.start();
        }

        for (var thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedImage oldImage = ImageIO.read(new File(originalImage));
        BufferedImage newImage = new BufferedImage(oldImage.getWidth(), oldImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        long start = System.currentTimeMillis();
        // recolorThreaded(oldImage, newImage);
        recolorMultiThreaded(oldImage, newImage, 2);
        long end = System.currentTimeMillis();

        long duration = end - start;


        File outputFile = new File(outputImage);
        ImageIO.write(newImage, "jpg", outputFile);
        System.out.println(String.valueOf(duration));

    }
}
