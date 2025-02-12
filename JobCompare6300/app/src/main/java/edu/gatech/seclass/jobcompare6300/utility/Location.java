package edu.gatech.seclass.jobcompare6300.utility;
import java.io.Serializable;

public class Location implements Serializable {
    private String city;
    private String state;
    private int colIndex;

    public Location(String city, String state, int colIndex) {
        this.city = city;
        this.state = state;
        this.colIndex = colIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }
}

