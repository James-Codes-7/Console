package model;

import java.util.ArrayList;

public class Ticket {

    private long ticketPNR;
    private int flightId;
    private long totalAmount;
    private String source;
    private String destination;

    private ArrayList<Passenger> passengerList;
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }
    public void setPassengerList(ArrayList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
    public long getTicketPNR() {
        return ticketPNR;
    }
    public void setTicketPNR(long ticketPNR) {
        this.ticketPNR = ticketPNR;
    }
    public int getFlightId() {
        return flightId;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    public long getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
