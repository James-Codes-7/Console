package control;
import repositary.FlightBookingDatabase;
import model.Passenger;
import model.Ticket;
import java.util.ArrayList;

public class PassengerControl {
    private FlightBookingDatabase flightBookingDatabase;
    public Passenger getPassenger(int passengerId) {
        ArrayList<Ticket> ticketList = flightBookingDatabase.getTicketList();
        for (Ticket ticket : ticketList) {
            for (Passenger passenger : ticket.getPassengerList()) {
                if (passenger.getPassengerId() == passengerId) {
                    return passenger;
                }
            }
        }
        return null;
    }
    public PassengerControl() {
        flightBookingDatabase = FlightBookingDatabase.getInstance();
    }
}

