package control;

import model.Flight;
import repositary.FlightBookingDatabase;
import view.ManagePassenger;

import java.util.ArrayList;
import java.util.List;

public class FlightControl {

    private static int FLIGHTIDGENERATE = 1234;
    private static int FLIGHTIDSTART = 1234;
    private ManagePassenger managePassenger;
    private FlightBookingDatabase flightBookingDatabase;

    public FlightControl(ManagePassenger managePassenger) {
        this.managePassenger = managePassenger;
        flightBookingDatabase = FlightBookingDatabase.getInstance();
    }

    public long flightFare(int flightId) {
        return flightBookingDatabase.getFlightList().get(flightId - FLIGHTIDSTART).getFare();
    }

    public List<Flight> checkForFlight(String fromPlace, String toPlace) {
        List<Flight> flightList = flightBookingDatabase.getFlightList();
        List<Flight> userNeedFlights = new ArrayList<>();
        byte count = 0;
        for (Flight flight : flightList) {
            ArrayList<String> routesCheck = flight.getFlightRoutes();
            count = 0;
            for (String route : routesCheck) {
                if (route.equals(fromPlace)) {
                    fromPlace = toPlace;
                    count++;
                }
                if (count == 2) {
                    userNeedFlights.add(flight);
                    break;
                }
            }
        }
        return userNeedFlights;
    }

    public boolean flightIdCheck(int flightId) {
        if (flightId < FLIGHTIDSTART || flightId > flightBookingDatabase.getFlightList().size() + FLIGHTIDSTART - 1) {
            return false;
        }
        return true;
    }

    public boolean seatsCheck(int count, int flightId) {

        Flight flight = flightBookingDatabase.getFlightList().get(flightId - FLIGHTIDSTART);
        if (flight.getNoOfSeats() >= count) {
            flight.setNoOfSeats(flight.getNoOfSeats() - count);
            return true;
        }
        return false;
    }

    public FlightControl() {
    }

    public void seatAdd(int passengerCount, int flightId) {
        if (flightId < FLIGHTIDSTART || flightId > flightBookingDatabase.getTicketList().size() + FLIGHTIDSTART)
            return;
        flightBookingDatabase.getFlightList().get(flightId - FLIGHTIDGENERATE).setFlightId(
                flightBookingDatabase.getFlightList().get(flightId - FLIGHTIDGENERATE).getFlightId() + passengerCount);
    }
}
