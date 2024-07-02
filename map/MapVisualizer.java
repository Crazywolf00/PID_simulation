package map;

import models.DataTransfer;
import models.Station;
import models.SubwayLine;

import java.util.List;
import java.util.Random;

public class MapVisualizer {

    private static  String[][] subwayMap;
    private static List<SubwayLine> subwayLines;
    private static int rows;
    private static int cols;


    public static void makeFrame() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                //frame
                if (i == 1 && j == 1) {
                    subwayMap[i][j] = "┌─";
                } else if (i == 1 && j == cols) {
                    subwayMap[i][j] = "─┐";
                } else if (i == rows && j == 1) {
                    subwayMap[i][j] = "└─";
                } else if (i == rows && j == cols) {
                    subwayMap[i][j] = "─┘";
                } else if (i == 1 || i == rows) {
                    subwayMap[i][j] = "──";
                } else if (j == 1) {
                    subwayMap[i][j] = "│ ";
                } else if (j == cols) {
                    subwayMap[i][j] = " │";
                }
            }
        }
    }

    public static void placeStation(SubwayLine stations) {
        for (Station station : stations.getStations()) {
            subwayMap[station.getxPosition()][station.getyPosition()] = station.getName();
        }


    }

    public static void drawLine(boolean horizontalFirst, int x1, int y1, int x2, int y2) {
        if (horizontalFirst) {
            while (x1 != x2) {
                if (subwayMap[x1][y1] == null) {
                    subwayMap[x1][y1] = " ║";
                }
                x1 += (x2 > x1) ? 1 : -1;
            }
            while (y1 != y2) {
                if (subwayMap[x1][y1] == null) {
                    subwayMap[x1][y1] = "══";
                }
                y1 += (y2 > y1) ? 1 : -1;
            }
        } else {
            while (y1 != y2) {
                if (subwayMap[x1][y1] == null) {
                    subwayMap[x1][y1] = "══";
                }
                y1 += (y2 > y1) ? 1 : -1;
            }
            while (x1 != x2) {
                if (subwayMap[x1][y1] == null) {
                    subwayMap[x1][y1] = " ║";
                }
                x1 += (x2 > x1) ? 1 : -1;
            }
        }
    }

    public static void drawPaths(SubwayLine subwayLine) {
        List<Station> stations = subwayLine.getStations();
        for (int i = 0; i < stations.size() - 1; i++) {
            Station current = stations.get(i);
            Station next = stations.get(i + 1);
            drawLine(current.isHorizontalFirst(), current.getxPosition(), current.getyPosition(), next.getxPosition(), next.getyPosition());
        }
    }

    public static void load(DataTransfer dataTransfer) {
        subwayMap = dataTransfer.getSubwayMap();
        subwayLines = dataTransfer.getSubwayLines();
        rows = subwayMap.length - 1;
        cols = subwayMap[0].length - 1;

        makeFrame();
        for (SubwayLine subwayLine: subwayLines) {
            placeStation(subwayLine);
            drawPaths(subwayLine);
        }


        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (subwayMap[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(subwayMap[i][j]);
                }
            }
            System.out.println("");
        }
//
    }

}
