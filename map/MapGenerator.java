package map;

import models.DataTransfer;
import models.Station;
import models.SubwayLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenerator {

    private static final Random random = new Random();

    private static final String[][] subwayMap = new String[50][100];
    //                                                    ^X^  ^Y^
    private static List<Station> stations = new ArrayList<>();
    private static List<SubwayLine> subwayLines = new ArrayList<>();
    private static final int rows = subwayMap.length - 1;
    private static final int cols = subwayMap[0].length - 1;

    public static String[][] getSubwayMap() {
        return subwayMap;
    }

    public static List<Station> getStations() {
        return stations;
    }

    public static void createStations() {
        Station startStation = new Station(
                random.nextInt(3, 15),
                random.nextInt(5, 25), "█S");
        Station endStation = new Station(
                subwayMap.length - random.nextInt(3, 15),
                subwayMap[0].length - random.nextInt(5, 25), "█E");
        stations.add(startStation);
        stations.add(endStation);

        boolean moreSpace;
        do {
            moreSpace = false;
            List<Station> stationsNew = new ArrayList<>(stations);

            for (int i = 0; i < stations.size() - 1; i++) {
                double distance = calculateDistance(
                        stations.get(i).getxPosition(), stations.get(i).getyPosition(),
                        stations.get(i + 1).getxPosition(), stations.get(i + 1).getyPosition());

                if (distance > 20) {
                    Station middleStation = createMiddleStation(stations.get(i), stations.get(i + 1), i);
                    if (isPositionValid(middleStation)) {
                        stationsNew.add(i + 1, middleStation);
                        moreSpace = true;
                        break;
                    }
                }
            }
            stations = stationsNew;
        } while (moreSpace);
        subwayLines.add(new SubwayLine(stations));
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static Station createMiddleStation(Station one, Station two, int i) {
        int xPosition, yPosition;
        do {
            xPosition = (one.getxPosition() + two.getxPosition()) / 2 + (random.nextInt(-5, 5));
            yPosition = (one.getyPosition() + two.getyPosition()) / 2 + (random.nextInt(-5, 5));
        } while (xPosition < 1 || xPosition >= rows || yPosition < 1 || yPosition >= cols); //todo generuje se do okrajů

        return new Station(xPosition, yPosition, "██");
    }

    public static boolean isPositionValid(Station station) {
        for (Station s : stations) {
            if (Math.abs(s.getxPosition() - station.getxPosition()) < 5 &&
                    Math.abs(s.getyPosition() - station.getyPosition()) < 5) {
                return false;
            }
        }
        return true;
    }

    public static DataTransfer load() {
        createStations();
        return new DataTransfer(subwayMap, subwayLines);
    }


}
