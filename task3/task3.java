
//directory contains / ?
//scanner try catch
// числа проверять на что-то другое ?
//directory windows

import java.util.Scanner;
import java.io.File;

public class task3 {
    public static void main(String[] argc) {
        String pathOfDirectory = argc[0];
        Scanner scanCashOne = null;
        Scanner scanCashTwo = null;
        Scanner scanCashThree = null;
        Scanner scanCashFour = null;
        Scanner scanCashFive = null;
        try {
            scanCashOne = new Scanner(new File(pathOfDirectory + "/Cash1.txt"));
            scanCashTwo = new Scanner(new File(pathOfDirectory + "/Cash2.txt"));
            scanCashThree = new Scanner(new File(pathOfDirectory + "/Cash3.txt"));
            scanCashFour = new Scanner(new File(pathOfDirectory + "/Cash4.txt"));
            scanCashFive = new Scanner(new File(pathOfDirectory + "/Cash5.txt"));
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        int interval = 0;
        float max = 0;
        float tempSum = 0;
        for (int k = 1; k <= 16; k++) {
            tempSum += Float.valueOf(scanCashOne.next());
            tempSum += Float.valueOf(scanCashTwo.next());
            tempSum += Float.valueOf(scanCashThree.next());
            tempSum += Float.valueOf(scanCashFour.next());
            tempSum += Float.valueOf(scanCashFive.next());
            if (tempSum > max) {
                //System.out.printf("%.2f", tempSum);
                //System.out.println();
                max = tempSum;
                interval = k;
            }
            tempSum = 0f;
        }
        System.out.println(interval);
    }
}
