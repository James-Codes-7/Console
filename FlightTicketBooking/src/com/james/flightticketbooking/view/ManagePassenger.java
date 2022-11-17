package view;

import control.FlightControl;
import control.PassengerControl;
import control.TicketControl;
import model.Flight;
import model.Passenger;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagePassenger {

    private FlightControl flightControl;
    private TicketView ticketView;
    private TicketControl ticketControl;
    private PassengerControl passengerControl;
    private byte option = 0;
    private Scanner scanner = new Scanner(System.in);

    public ManagePassenger() {
        flightControl = new FlightControl(this);
        ticketControl = new TicketControl(this);
        ticketView = new TicketView();
        passengerControl = new PassengerControl();
    }

    public void passengerView() {
        System.out.println("-->Welcome To IRCTC<--");
        while (true) {
            System.out.println("Ticket Booking     Press 1");
            System.out.println("PNR Status         Press 2");
            System.out.println("Cancel Tickets     Press 3");
            System.out.println("Search Passenger   Press 4");
            System.out.println("View Flight Roots  Press 5");
            System.out.println("Exit               Press 6");
            System.out.println("Enter the option");
            option = scanner.nextByte();
            if (option == 6) return;
            switch (option) {
                case 1:
                    ticketBooking();
                    break;
                case 2:
                    statusOfPNR();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    searchPassenger();
                    break;
                case 5:
                default:
                    System.out.println("Enter the valid one");
            }
        }
    }

    private void searchPassenger() {
        System.out.println("Enter the passenger Id");
        int passengerId = scanner.nextInt();
        Passenger passenger = passengerControl.getPassenger(passengerId);
        if (passenger == null) {
            System.out.println("Wrong Id");
            return;
        }
        System.out.println("\n-->Passenger Details<--");
        System.out.println("Passenger Name: " + passenger.getPassengerName() + " || Passenger Id:    " + passenger.getPassengerId()
                + " || Passenger Age:" + passenger.getAge() + " || Passenger Gender:" + passenger.getPassengerName() + "\n");
    }

    private void cancelTicket() {
        System.out.println("Enter the PNR Number");
        int PNRNumber = scanner.nextInt();
        Ticket ticket = ticketControl.getPNRStatus(PNRNumber);
        if (ticket == null) {
            System.out.println("-->Wrong PNRNumber<--");
            return;
        }
        ticketControl.cancelProcess(PNRNumber);
    }

    private void statusOfPNR() {
        System.out.println("Enter the PNR Number");
        int PNRNumber = scanner.nextInt();
        Ticket ticket = ticketControl.getPNRStatus(PNRNumber);
        if (ticket == null) {
            System.out.println("-->Wrong PNR<--");
            return;
        }
        ticketView.displayTicket(ticket);
    }

    private void ticketBooking() {

        while (true) {
            scanner.nextLine();
            System.out.println("Enter the From Station");
            String fromPlace = scanner.nextLine();
            System.out.println("Enter the To Station");
            String toPlace = scanner.nextLine();
            long ticketAmount = 0;
            List<Flight> userNeedFlight = flightControl.checkForFlight(fromPlace, toPlace);
            if (userNeedFlight.size() == 0) {
                alert("-->No flights<--");
                return;
            }
            for (Flight flight : userNeedFlight) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Flight Name:" + flight.getFlightName());
                System.out.println("Flight Id:" + flight.getFlightId());
                System.out.println("Flight Arraival time:" + flight.getArraivalTime());
                System.out.println("Flight Departure time:" + flight.getDepartureTime());
                System.out.println("Flight Number Of Seates:" + flight.getNoOfSeats());
                System.out.println("Flight  fare:" + flight.getFare());
                System.out.println("Route:");
                for (String routes : flight.getFlightRoutes()) {
                    System.out.print(routes + ",");
                }
                System.out.println("\n-------------------------------------------------------------");
            }
            System.out.println("\nEnter the Flight Id");
            int flightId = scanner.nextInt();
            if (flightControl.flightIdCheck(flightId)) {
            } else {
                alert("-->Wrong Flight Id<--");
                continue;
            }
            System.out.println("Enter the Number of Passenger");
            int passengerCount = scanner.nextInt();
            ArrayList<Passenger> passengerList = getPassengerList(passengerCount, flightId);
            System.out.println("Pay            Press 1");
            System.out.println("Cancel         Press 2");
            System.out.println("Reschedule     Press 3");
            byte bookStatus = scanner.nextByte();
            if (bookStatus != 1) {
                flightControl.seatAdd(passengerCount, flightId);
                return;
            }
            ticketAmount = flightControl.flightFare(flightId);
            Ticket ticket = new Ticket();
            ticket.setFlightId(flightId);
            ticket.setPassengerList(passengerList);
            ticket.setTotalAmount(ticketAmount * passengerCount);
            ticketControl.bookTicket(ticket);
            ticketView.displayTicket(ticket);
            break;
        }
    }

    public void alert(String message) {
        System.out.println(message);
    }

    private ArrayList<Passenger> getPassengerList(int passengerCount, int flightId) {
        String pasengerName = "-";
        byte age = 0;
        String gender = "-";
        int userId = 0;
        ArrayList<Passenger> passengerList = new ArrayList<>();
        Passenger passenger = null;
        scanner.nextLine();
        for (int i = 0; i < passengerCount; i++) {

            System.out.println("Enter Passenger:"+(i+1));
            passenger = new Passenger();
            if (i != 0) scanner.nextLine();
            System.out.println("Enter the name");
            pasengerName = scanner.nextLine();
            System.out.println("Enter the age");
            age = scanner.nextByte();
            System.out.println("Enter the Genter");
            gender = scanner.next();
            System.out.println("Enter the Id");
            userId = scanner.nextInt();
            if (flightControl.seatsCheck(1, flightId)) {
                passenger.setTicketStatus("CNF");
            } else passenger.setTicketStatus("WL");
            passenger.setPassengerName(pasengerName);
            passenger.setAge(age);
            passenger.setGender(gender);
            passenger.setPassengerId(userId);
            passengerList.add(passenger);
        }
        return passengerList;
    }
}
