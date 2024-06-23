package map;

import models.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenerator {

    private static Random random = new Random();
    private static String[][] map = new String[35][100];

    private static List<Station> stations = new ArrayList<>();
    private static int[] startPosition = new int[2];
    private static int[] endPosition = new int[2];

    private static int rows = map.length - 1;
    private static int cols = map[0].length - 1;

    public static void createStations() {
        Station startStation = new Station(
                random.nextInt(3, 15),
                random.nextInt(5, 25));
        Station endStation = new Station(
                map.length - random.nextInt(3, 15),
                map[0].length - random.nextInt(5, 25));
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
                    Station middleStation = createMiddleStation(stations.get(i), stations.get(i + 1));
                    if (isPositionValid(middleStation)) {
                        stationsNew.add(i + 1, middleStation);
                        moreSpace = true;
                    }
                }
            }
            stations = stationsNew;
        } while (moreSpace);
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static Station createMiddleStation(Station one, Station two) {
        int xPosition, yPosition;
        do {
            xPosition = (one.getxPosition() + two.getxPosition()) / 2 ;
            yPosition = (one.getyPosition() + two.getyPosition()) / 2 ;
        } while (xPosition < 1 || xPosition >= rows || yPosition < 1 || yPosition >= cols);

        return new Station(xPosition, yPosition);
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

    public static void makeFrame() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                //frame
                if (i == 1 && j == 1) {
                    map[i][j] = "┌─";
                } else if (i == 1 && j == cols) {
                    map[i][j] = "─┐";
                } else if (i == rows && j == 1) {
                    map[i][j] = "└─";
                } else if (i == rows && j == cols) {
                    map[i][j] = "─┘";
                } else if (i == 1 || i == rows) {
                    map[i][j] = "──";
                } else if (j == 1) {
                    map[i][j] = "│ ";
                } else if (j == cols) {
                    map[i][j] = " │";
                }
            }
        }
    }

    public static void placeStation() {
        for (Station station : stations) {
            map[station.getxPosition()][station.getyPosition()] = "██";
        }
    }

    public static void drawLine(int x1, int y1, int x2, int y2) {
        boolean horizontalFirst = random.nextBoolean();

        if (horizontalFirst) {
            while (x1 != x2) {
                if (map[x1][y1] == null) {
                    map[x1][y1] = " ║";
                }
                x1 += (x2 > x1) ? 1 : -1;
            }
            while (y1 != y2) {
                if (map[x1][y1] == null) {
                    map[x1][y1] = "══";
                }
                y1 += (y2 > y1) ? 1 : -1;
            }
        } else {
            while (y1 != y2) {
                if (map[x1][y1] == null) {
                    map[x1][y1] = "══";
                }
                y1 += (y2 > y1) ? 1 : -1;
            }
            while (x1 != x2) {
                if (map[x1][y1] == null) {
                    map[x1][y1] = " ║";
                }
                x1 += (x2 > x1) ? 1 : -1;
            }
        }

        if (map[x1][y1] == null) {
            map[x1][y1] = "##";
        }
    }

    public static void drawPaths() {
        for (int i = 0; i < stations.size() - 1; i++) {
            Station current = stations.get(i);
            Station next = stations.get(i + 1);
            drawLine(current.getxPosition(), current.getyPosition(), next.getxPosition(), next.getyPosition());
        }
    }
    public static void load() {
        makeFrame();
        createStations();
        placeStation();
        drawPaths();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (map[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println("");
        }
//        for (int i = -1; i <= rows; i++) {
//            for (int j = -1; j <= cols; j++) {
//
//                //stations
//                    if((i == startPosition[0] && j == startPosition[1]) || (i == endPosition[0] && j == endPosition[1])) {
//                        System.out.print("XX");
//                    } else {
//                        System.out.print("  ");
//                    }
//                }
//            }
//            System.out.println("");
//        }
    }


}
