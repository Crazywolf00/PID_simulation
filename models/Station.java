package models;

public class Station {
    private int xPosition;
    private int yPosition;

    private String name;

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
    public String getName() {
        return name;
    }

    public Station(int xPosition, int yPosition, String name) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.name = name;
    }
}
