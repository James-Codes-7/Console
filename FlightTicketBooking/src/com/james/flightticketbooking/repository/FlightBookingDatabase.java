package repositary;

import model.Flight;
import model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FlightBookingDatabase {

    private static FlightBookingDatabase flightBookingDatabase;
    private final ArrayList<Ticket> ticketList;
    private final ArrayList<Flight> flightList;

    public static FlightBookingDatabase getInstance() {
        if (flightBookingDatabase == null) flightBookingDatabase = new FlightBookingDatabase();
        return flightBookingDatabase;
    }

    private FlightBookingDatabase() {
        ticketList = new ArrayList<>();
        flightList = new ArrayList<>();

    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(Ticket ticketList) {
        this.ticketList.add(ticketList);
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(Flight flightList) {
        this.flightList.add(flightList);
    }
}
