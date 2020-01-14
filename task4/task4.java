import java.io.File;
import java.util.*;

public class task4 {
    public static void main(String[] argc) {
        String path = argc[0];
        Scanner sc;
        try {
            sc = new Scanner(new File(path));
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return ;
        }
        SortedMap<Integer, ArrayList<Boolean>> points = new TreeMap<>();
        getPoints(points, sc);
        int peoplePrev = 0;
        int peopleCur = 0;
        int peopleMax = 0;
        int i = 0;
        List<Boolean> temp = new ArrayList<>();
        List<Integer> intervals = new ArrayList<>();
        for(int key: points.keySet()) {
            temp = points.get(key);
            for (boolean isEnter : temp) {
                if (isEnter) {
                    peopleCur++;
                } else {
                    peopleCur--;
                }
            }
            if (peopleCur > peoplePrev) {
                if (peopleCur > peopleMax) {
                    intervals.clear();
                    intervals.add(key);
                    peopleMax = peopleCur;
                } else if (peopleCur == peopleMax) {
                    intervals.add(key);
                }
            } else if (peopleCur < peoplePrev && peoplePrev == peopleMax) {
                intervals.add(key);
            }
            peoplePrev = peopleCur;
        }
        printIntervals(intervals);
    }

    static private void getPoints(SortedMap<Integer, ArrayList<Boolean>> points, Scanner sc) {
        String[] temp = null;
        while(sc.hasNextLine()) {
            temp = sc.nextLine().split(" ");
            addPoint(points, temp[0], true);
            addPoint(points, temp[1], false);
        }
    }

    static private void addPoint(SortedMap<Integer, ArrayList<Boolean>> points, String temp, Boolean isEnter) {
        int size = temp.length();
        int colon = temp.indexOf(':');
        int time = 0;
        try {
            time = Integer.parseInt(temp.substring(0, colon)) * 3600;
            time += Integer.parseInt(temp.substring(colon + 1, size)) * 60;
        } catch(Exception e) {
            System.out.println("Error: format of data in file is invalid");
            System.exit(0);
        }
        if(points.containsKey(time)) {
            points.get(time).add(isEnter);
        } else {
            ArrayList<Boolean> value = new ArrayList<>();
            value.add(isEnter);
            points.put(time, value);
        }
    }

    static private void printIntervals(List<Integer> points) {
        int hours ;
        int minutes;
        String min;
        for (int i = 0; i < points.size(); i = i + 2) {
            hours = points.get(i) / 3600;
            minutes = (points.get(i) / 60) % 60;
            min = Integer.toString(minutes);
            min = min.length() == 1 ? "0" + min : min;
            System.out.print(hours + ":" + min + " ");
            hours = points.get(i + 1) / 3600;
            minutes = (points.get(i + 1) / 60) % 60;
            min = Integer.toString(minutes);
            min = min.length() == 1 ? "0" + min : min;
            System.out.println(hours + ":" + min);
        }
    }
}