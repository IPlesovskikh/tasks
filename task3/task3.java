
//directory contains / ?
//scanner try catch
// числа проверять на что-то другое ?

import java.util.Scanner;
import java.io.File;

public class task3 {
    public static void main(String[] argc) {
        String pathOfDirectory = argc[0];
        Scanner scanCashOne = new Scanner(new File(pathOfDirectory + "//Cash1.txt"));
        Scanner scanCashTwo = new Scanner(new File(pathOfDirectory + "//Cash2.txt"));
        Scanner scanCashThree = new Scanner(new File(pathOfDirectory + "//Cash3.txt"));
        Scanner scanCashFour = new Scanner(new File(pathOfDirectory + "//Cash4.txt"));
        Scanner scanCashFive = new Scanner(new File(pathOfDirectory + "//Cash5.txt"));

        int interval = 0;
        float max = 0;
        float tempSum = 0;
        for (int k = 1; k <= 16; k++) {
            tempSum += scanCashOne.nextFloat();
            tempSum += scanCashTwo.nextFloat();
            tempSum += scanCashThree.nextFloat();
            tempSum += scanCashFour.nextFloat();
            tempSum += scanCashFive.nextFloat();
            if (tempSum > max) {
                max = tempSum;
                interval = k;
            }
        }
        System.out.println(interval);
    }
}