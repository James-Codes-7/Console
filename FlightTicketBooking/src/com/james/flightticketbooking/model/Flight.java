package model;

import java.util.ArrayList;

public class Flight {

    private int flightId;
    private String flightName;
    private int noOfSeats;
    private String arraivalTime;
    private String departureTime;
    private long fare;

    private ArrayList<String> flightRoutes;

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public ArrayList<String> getFlightRoutes() {
        return flightRoutes;
    }

 public void setFlightRoutes(ArrayList<String> routes)
 {
     flightRoutes=routes;
 }

    public long getFare() {
        return fare;
    }

    public void setFare(long fare) {
        this.fare = fare;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getArraivalTime() {
        return arraivalTime;
    }

    public void setArraivalTime(String arraivalTime) {
        this.arraivalTime = arraivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
