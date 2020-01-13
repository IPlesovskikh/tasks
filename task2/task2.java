import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//комментарии сделать
// сделать комментарий первый y второй x

public class task2 {
    public static void main(String[] argc) {
        String pathOfRectangle = argc[0];
        String pathOfPoints = argc[1];
        File fileRect = new File(pathOfRectangle);
        File filePoints = new File(pathOfPoints);
        Scanner scRect = new Scanner(fileRect); //exception поставить
        Scanner scPoints = new Scanner(filePoints);
        float[] rect = new float[8];
        getCoordinatesOfRectangle(rect, scRect);
        ArrayList<Float> points = new ArrayList<>(8);
        getCoordinatesOfPoints(points, scPoints);
        float x = 0;
        float y = 0;
        for(int k = 0; k < points.size(); k = k + 2){
            y = points.get(k);
            x = points.get(k + 1);
            if (checkInRect(x, y, rect) == 1) {
                break ;
            }
            if (checkOnAngle(x, y, rect) == 1) {
                break ;
            }
            if (checkOnSide(x, y, rect) == 1) {
                break ;
            }
            System.out.println(3);
        }
    }

    static private int checkInRect(float x, float y, float[] rect) {
        if (x > rect[1] && x < rect[3]) {
            if (y > rect[0] && y < rect[6]) {
                System.out.println(2);
                return 1;
            }
        }
        return 0;
    }

    static private int checkOnAngle(float x, float y, float[] rect) {
        boolean angle = false;
        if(y == rect[0] && x == rect[1]) {
            angle = true;
        } else if (y == rect[2] && x == rect[3]) {
            angle = true;
        } else if (y == rect[4] && x == rect[5]) {
            angle = true;
        } else if (y == rect[6] && x == rect[7]) {
            angle = true;
        }
        if (angle) {
            System.out.println(0);
            return 1;
        }
        return 0;
    }

    static private int checkOnSide(float x, float y, float[] rect) {
        boolean side = false;
        if(y == rect[0] && x > rect[1] && x < rect[3]) {
            side = true;
        } else if (x == rect[3] && rect[2] < y && y < rect[4]) {
            side = true;
        } else if (y == rect[6] && rect[7] < x && x < rect[5]) {
            side = true;
        } else if (x == rect[1] && rect[0] < y && y < rect[6]) {
            side = true;
        }
        if (side) {
            System.out.println(1);
            return 1;
        }
        return 0;
    }

    static private void getCoordinatesOfRectangle(float[] rect, Scanner sc) {
        int i = 0;
        while(sc.hasNextFloat() && i < 8) {
            rect[i] = sc.nextFloat();
            i++;
        }
    }
    static private void getCoordinatesOfPoints(ArrayList<Float> points, Scanner sc) {
        while(sc.hasNextFloat()) {
            points.add(sc.nextFloat());
        }
    }
}