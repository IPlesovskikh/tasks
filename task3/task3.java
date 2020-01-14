import java.util.Scanner;
import java.io.File;

public class task3 {
    public static void main(String[] argc) {
        if (argc.length != 1) {
            System.out.println("Usage: java task3.java <nameOfDirectory>");
            return;
        }
        String pathOfDirectory = argc[0];
        Scanner scanCashOne;
        Scanner scanCashTwo;
        Scanner scanCashThree;
        Scanner scanCashFour;
        Scanner scanCashFive;
        try {
            scanCashOne = new Scanner(new File(pathOfDirectory + File.separator + "Cash1.txt"));
            scanCashTwo = new Scanner(new File(pathOfDirectory + File.separator + "Cash2.txt"));
            scanCashThree = new Scanner(new File(pathOfDirectory + File.separator + "Cash3.txt"));
            scanCashFour = new Scanner(new File(pathOfDirectory + File.separator + "Cash4.txt"));
            scanCashFive = new Scanner(new File(pathOfDirectory + File.separator + "Cash5.txt"));
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return;
        }
        int interval = 0;
        float max = 0;
        float tempSum = 0;
        try {
            for (int k = 1; k <= 16; k++) {
                tempSum += Float.parseFloat(scanCashOne.next());
                tempSum += Float.parseFloat(scanCashTwo.next());
                tempSum += Float.parseFloat(scanCashThree.next());
                tempSum += Float.parseFloat(scanCashFour.next());
                tempSum += Float.parseFloat(scanCashFive.next());
                if (tempSum > max) {
                    max = tempSum;
                    interval = k;
                }
                tempSum = 0f;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return ;
        }
        System.out.println(interval);
    }
}