package view;

import control.AdminControl;
import control.FlightControl;
import control.TicketControl;
import model.Flight;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageAdmin {
    private Scanner scanner = new Scanner(System.in);
    private AdminControl adminControl;
    private TicketView ticketView;
    private TicketControl ticketControl;

    public ManageAdmin() {
        adminControl = new AdminControl(this);
        ticketView = new TicketView();
        ticketControl = new TicketControl(this);
    }

    public void alert(String message) {
        System.out.println(message);
    }

    public void adminView() {
        byte option = 0;
        while (true) {
            System.out.println("\nAdd Flight       Press 1");
            System.out.println("View Flight List Press 2");
            System.out.println("Ticket List      Press 3");
            System.out.println("Conform Ticket   Press 4");
            System.out.println("Exit             Press 5");
            System.out.println("Enter the option");
            option = scanner.nextByte();
            if (option == 5) return;
            switch (option) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    viewFlightList();
                    break;
                case 3:
                    viewTicketList();
                    break;
                case 4:
                    conformTicket();
                    break;
                default:
                    System.out.println("Enter the correct one");
            }
        }
    }

    private void conformTicket() {
        System.out.println("Enter the TicketId");
        long ticketPNR = scanner.nextLong();
        System.out.println("Enter the PassengerId");
        int passengerId = scanner.nextInt();
        ticketControl.conformTicket(ticketPNR, passengerId);
    }

    private void viewFlightList() {
        ArrayList<Flight> flightList = adminControl.getFlightList();
        for (Flight flight : flightList) {
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
        }
    }
    private void viewTicketList() {
        ticketView.ticketList();
    }
    private void addFlight() {
        System.out.println("Enter the Flight Id");
        int flightId = scanner.nextInt();
        System.out.println("Enter the flight name");
        String flightName = scanner.next();
        System.out.println("Number of seats");
        short noOfSeats = scanner.nextByte();
        System.out.println("Enter Arraival time");
        String arraivalTime = scanner.next();
        System.out.println("Enter the Departure time");
        String departureTime = scanner.next();
        System.out.println("Enter the ticket fare");
        long fare = scanner.nextLong();
        System.out.println("Enter the Number of Routes");
        int routes = scanner.nextInt();
        ArrayList<String> routeList = new ArrayList<>();
        for (int i = 0; i < routes; i++) {
            routeList.add(scanner.next());
        }
        Flight flight = new Flight();
        flight.setFlightRoutes(routeList);
        flight.setFlightId(flightId);
        flight.setFlightName(flightName);
        flight.setDepartureTime(departureTime);
        flight.setArraivalTime(arraivalTime);
        flight.setFare(fare);
        flight.setNoOfSeats(noOfSeats);
        adminControl.setFlight(flight);

    }
}
