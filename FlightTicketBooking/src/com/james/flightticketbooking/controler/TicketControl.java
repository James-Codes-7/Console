package control;

import model.Flight;
import model.Passenger;
import repositary.FlightBookingDatabase;
import model.Ticket;
import view.ManageAdmin;
import view.ManagePassenger;

import java.util.List;

public class TicketControl {

    public FlightBookingDatabase flightBookingDatabase;
    private ManagePassenger managePassenger;
    private static int PNRNUMBERSTART = 2000;
    private static int PNRNumberGenerate = 2000;
    private static int FLIGHTIDSTART = 1234;

    public TicketControl(ManagePassenger managePassenger) {
        this.managePassenger = managePassenger;
        flightBookingDatabase = FlightBookingDatabase.getInstance();
    }

    private ManageAdmin manageAdmin;

    public TicketControl() {
        flightBookingDatabase = FlightBookingDatabase.getInstance();
    }

    public TicketControl(ManageAdmin manageAdmin) {
        this.manageAdmin = manageAdmin;
    }

    public void conformTicket(long ticketPNR, int passengerId) {
        List<Ticket> ticketList = flightBookingDatabase.getTicketList();
        for (Ticket ticket : ticketList) {
            if (ticket.getTicketPNR() == ticketPNR) {
                List<Passenger> passengerList = ticket.getPassengerList();
                for (Passenger passenger : passengerList) {
                    if (passenger.getPassengerId() == passengerId) {
                        if (passenger.getTicketStatus().equals("WL")) {
                            passenger.setTicketStatus("CNF");
                            manageAdmin.alert("-->Ticket Conform SuccessFully<--");

                        }
                    }
                }
            }
        }
    }

    public void cancelProcess(long PNRNumber) {
        long totalAmount = flightBookingDatabase.getTicketList().get((int) PNRNumber - PNRNUMBERSTART).getTotalAmount();
        Ticket ticket = flightBookingDatabase.getTicketList().get((int) PNRNumber - PNRNUMBERSTART);
        Flight flight = flightBookingDatabase.getFlightList().get(ticket.getFlightId() - FLIGHTIDSTART);
        flight.setNoOfSeats(flight.getNoOfSeats() + ticket.getPassengerList().size());
        flightBookingDatabase.getTicketList().remove((int) PNRNumber - PNRNUMBERSTART);
        managePassenger.alert("-->Ticket Cancelled Successfully.Your refund " + totalAmount + " will be processed soon.<--");
    }
    public void bookTicket(Ticket ticket) {
        ticket.setTicketPNR(PNRNumberGenerate++);
        flightBookingDatabase.setTicketList(ticket);
        managePassenger.alert("Your PNR:" + (PNRNumberGenerate - 1));
        managePassenger.alert("-->Ticket Booked SuccessFully<--");
    }

    public Ticket getPNRStatus(int PNR) {
        if (PNR < PNRNUMBERSTART || PNR > flightBookingDatabase.getTicketList().size() + PNRNUMBERSTART)
            return null;
        Ticket ticket = flightBookingDatabase.getTicketList().get((PNR - PNRNUMBERSTART));
        int passengerCount = ticket.getPassengerList().size();

        flightBookingDatabase.getFlightList().get(ticket.getFlightId() - FLIGHTIDSTART).setNoOfSeats(
                flightBookingDatabase.getFlightList().get(ticket.getFlightId() - FLIGHTIDSTART).getNoOfSeats() + passengerCount
        );
        return ticket;
    }
}
