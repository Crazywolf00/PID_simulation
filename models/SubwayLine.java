package models;

import java.util.List;

public class SubwayLine {

    private List<Station> stations;


    public SubwayLine(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }
}
