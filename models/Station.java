package models;

import java.util.Random;

public class Station {
    private int xPosition;
    private int yPosition;

    private String name;

    public boolean horizontalFirst = new Random().nextBoolean();
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
    public String getName() {
        return name;
    }
    public boolean isHorizontalFirst() {
        return horizontalFirst;
    }



    public Station(int xPosition, int yPosition, String name) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.name = name;
    }
}
