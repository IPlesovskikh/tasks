import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class task2 {
    public static void main(String[] argc) {
        String pathOfPolygon = argc[0];
        String pathOfPoints = argc[1];
        File filePolygon = new File(pathOfPolygon);
        File filePoints = new File(pathOfPoints);
        Scanner scRect;
        Scanner scPoints;
        try {
            scRect = new Scanner(filePolygon);
            scPoints = new Scanner(filePoints);
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return ;
        }
        float[] polygon = new float[8];
        getCoordinatesOfRectangle(polygon, scRect);
        ArrayList<Float> points = new ArrayList<>();
        getCoordinatesOfPoints(points, scPoints);
        float x;
        float y;
        int status;
        for(int k = 0; k < points.size(); k = k + 2){
            y = points.get(k);
            x = points.get(k + 1);
            if (checkOnAngle(x, y, polygon) == 1) {
                System.out.println(0);
                continue ;
            }
            if ((status = checkInsidePolygon(x, y, polygon)) == 1 || status == 2) {
                if(status == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
                continue ;
            }
            System.out.println(3);
        }
    }

    static private int checkInsidePolygon(float x, float y, float[] polygon) {

        float firstSide = (polygon[0] - x) * (polygon[3] - polygon[1]) - (polygon[2] - polygon[0]) *  (polygon[1] - y);
        float secondSide = (polygon[2] - x) * (polygon[7] - polygon[3]) - (polygon[6] - polygon[2] ) * (polygon[3] - y);
        float thirdSide = (polygon[6] - x) * (polygon[1] - polygon[7]) - (polygon[0] - polygon[6]) *  (polygon[7] - y);
        int status = checkInsideOrOnSide(firstSide, secondSide, thirdSide);
        if (status != 0) {
            return status;
        }
        firstSide = (polygon[4] - x) * (polygon[7] - polygon[5]) - (polygon[6] - polygon[4]) *  (polygon[5] - y);
        secondSide = (polygon[6] - x) * (polygon[3] - polygon[7]) - (polygon[2] - polygon[6] ) * (polygon[7] - y);
        thirdSide = (polygon[2] - x) * (polygon[5] - polygon[3]) - (polygon[4] - polygon[2]) *  (polygon[3] - y);
        status = checkInsideOrOnSide(firstSide, secondSide, thirdSide);
        return status;
    }

    static private int checkInsideOrOnSide(float firstSide, float secondSide, float thirdSide) {
        if ((firstSide > 0 && secondSide > 0 && thirdSide > 0) || (firstSide < 0 && secondSide < 0 && thirdSide < 0))
            return 2;
        if ((firstSide == 0 && secondSide > 0 && thirdSide > 0) || (firstSide == 0 && secondSide < 0 && thirdSide < 0))
            return 1;
        if ((firstSide > 0 && secondSide > 0 && thirdSide == 0) || (firstSide < 0 && secondSide < 0 && thirdSide == 0))
            return 1;
        return 0;
    }

    static private int checkOnAngle(float x, float y, float[] polygon) {
        boolean angle = false;
        if(x == polygon[0] && y == polygon[1]) {
            angle = true;
        } else if (x == polygon[2] && y == polygon[3]) {
            angle = true;
        } else if (x == polygon[4] && y == polygon[5]) {
            angle = true;
        } else if (x == polygon[6] && y == polygon[7]) {
            angle = true;
        }
        if (angle) {
            return 1;
        }
        return 0;
    }

    static private void getCoordinatesOfRectangle(float[] polygon, Scanner sc) {
        int i = 0;
        while(sc.hasNext() && i < 8) {
            polygon[i] = Float.valueOf(sc.next());
            i++;
        }
        if (i != 8) {
            System.out.println("Error: File1 must contain four coordinates(x, y) of rectangle");
            System.exit(0);
        }
    }
    static private void getCoordinatesOfPoints(ArrayList<Float> points, Scanner sc) {
        while(sc.hasNext()) {
            points.add(Float.valueOf(sc.next()));
        }
        if (points.size() % 2 != 0) {
            System.out.println("Error: File2 must contain coordinates(x, y) for each point/ incomplete data");
            System.exit(0);
        }
    }
}
