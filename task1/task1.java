import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class task1 {

    public static void main(String[] argc) {
        if (argc.length != 1) {
            System.out.println("Usage: java task1.java <nameOfFile>");
            return;
        }
        String path = argc[0];
        ArrayList<Short> array = new ArrayList<>(1000);
        File file = new File(path);
        Scanner sc;
        try {
            sc = new Scanner(file);
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return ;
        }
        while(sc.hasNextShort()) {
            array.add(sc.nextShort());
        }
        if (array.size() == 0) {
            System.out.println("Error: File is empty or doesn't contain numbers [−32768, +32767]");
            return ;
        }
        Collections.sort(array);

        double percentile;
        double median;
        double max;
        double min;
        double average;
        percentile = getPercentile(array);
        median = getMedian(array);
        min = (double)array.get(0);
        max = (double)array.get(array.size() - 1);
        average = getAverage(array);
        System.out.printf(Locale.US, "%.2f", percentile);
        System.out.println();
        System.out.printf(Locale.US,"%.2f", median);
        System.out.println();
        System.out.printf(Locale.US,"%.2f", max);
        System.out.println();
        System.out.printf(Locale.US,"%.2f", min);
        System.out.println();
        System.out.printf(Locale.US,"%.2f", average);
        System.out.println();
    }

    static private double getPercentile(ArrayList<Short> array) {
        double x = 0.9 * (array.size() - 1) + 1;
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

    static private double getAverage(ArrayList<Short> array){
        double sum = 0;
        for(short num: array) {
            sum += num;
        }
        return sum / (double)array.size();
    }
}