import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class task1 {

    public static void main(String[] argc) {
        String path = argc[0];
        ArrayList<Short> array = new ArrayList<>(1000);
        File file = new File(path);
        Scanner sc = new Scanner(file); //exception поставить
        while(sc.hasNextShort()) {
            array.add(sc.nextShort());
        }
        double percentile;
        double median;
        Double max = -32768.00; // запятая надо ?
        Double min = 32767.00;
        double average;

        percentile = getPercentile(array);
        median = getMedian(array);
        getMinMax(array, min, max);
        average = getAverage(array);
        System.out.printf("%.2f", percentile);
        System.out.printf("%.2f", median);
        System.out.printf("%.2f", max);
        System.out.printf("%.2f", min);
        System.out.printf("%.2f", average);
    }

    static private double getPercentile(ArrayList<Short> array) {
        double x = 0.9 * array.size();
        int i = 0;
        for(; i < array.size(); i++) {
            if (x > array.get(i)) {
                if(x < array.get(i + 1)) {
                    break;
                }
            }
        }
        return array.get(i) + 0.1 * (array.get(i + 1) - array.get(i));
    }

    private static double getMedian(ArrayList<Short> array) {
        return array.get(array.size() / 2);
    }

    private static void getMinMax(ArrayList<Short> array, Double min, Double max) {
        for(short num: array) {
            if (num > max) {
                max = (double)num;
            }
            else if(num < min) {
                min = (double)num;
            }
        }
    }

    static private double getAverage(ArrayList<Short> array){
        int sum = 0;
        for(short num: array) {
            sum += num;
        }
        return (double)(sum / array.size());
    }
}