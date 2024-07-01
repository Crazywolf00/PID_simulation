package models;

import java.util.List;

public class DataTransfer {

    private String[][] subwayMap;

    private List<SubwayLine> subwayLines;

    public DataTransfer(String[][] subwayMap, List<SubwayLine> subwayLines) {
        this.subwayMap = subwayMap;
        this.subwayLines = subwayLines;
    }

    public String[][] getSubwayMap() {
        return subwayMap;
    }

    public List<SubwayLine> getSubwayLines() {
        return subwayLines;
    }
}
