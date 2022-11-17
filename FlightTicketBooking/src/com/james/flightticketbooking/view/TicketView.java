package view;

import control.TicketControl;
import model.Flight;
import model.Passenger;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketView {

    private TicketControl ticketControl;

    public TicketView() {
        ticketControl = new TicketControl();
    }

    public void displayTicket(Ticket ticket) {
        System.out.println("--------------------------------------->Your Ticket<------------------------------------------");
        System.out.println("Ticket Id:" + ticket.getTicketPNR());
        System.out.println("-->Flight Details<--");
        Flight flight = ticketControl.flightBookingDatabase.getFlightList().get(ticket.getFlightId() - 1234);
        System.out.println("Flight Name:" + flight.getFlightName() + "|| Flight Id:" + flight.getFlightId() + " " +
                " || Flight Arraival Time:" + flight.getArraivalTime() + " || Flight Departure Time:" + flight.getDepartureTime() + "" +
                " || Flight Source:" + ticket.getSource() + " || " +
                "Flight Destination:" + ticket.getDestination() + " || Total ticket Amount:" + ticket.getTotalAmount());

        System.out.println("-->Passenger Details<--");
        ArrayList<Passenger> passengerList = ticket.getPassengerList();
        for (Passenger passenger : passengerList) {
            System.out.println("Passenger Name: " + passenger.getPassengerName() + " || Passenger Id:    " + passenger.getPassengerId()
                    + " || Passenger Age:" + passenger.getAge() + " || Passenger Gender:" + passenger.getGender() + " || Ticket Status " + passenger.getTicketStatus());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public void ticketList() {
        List<Ticket> ticketList = ticketControl.flightBookingDatabase.getTicketList();
        System.out.println("-------------------------------------->Ticket List<------------------------------------------");
        for (Ticket ticket : ticketList) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("Ticket Id:" + ticket.getTicketPNR());

            System.out.println("-->Flight Details<--");
            Flight flight = ticketControl.flightBookingDatabase.getFlightList().get(ticket.getFlightId() - 1234);
            System.out.println("Flight Name:" + flight.getFlightName() + "|| Flight Id:" + flight.getFlightId() + " " +
                    " || Flight Arraival Time:" + flight.getArraivalTime() + " || Flight Departure Time:" + flight.getDepartureTime() + "" +
                    " || Flight Source:" + ticket.getSource() + " || " +
                    "Flight Destination:" + ticket.getDestination() + " || Total ticket Amount:" + ticket.getTotalAmount());

            System.out.println("-->Passenger Details<--");
            ArrayList<Passenger> passengerList = ticket.getPassengerList();
            for (Passenger passenger : passengerList) {
                System.out.println("Passenger Name: " + passenger.getPassengerName() + " || Passenger Id:    " + passenger.getPassengerId()
                        + " || Passenger Age:" + passenger.getAge() + " || Passenger Gender:" + passenger.getPassengerName());
            }
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }


}
