package view;

import repositary.FlightSetup;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightBookingManagementView {

    private ManageAdmin manageAdmin;
    private FlightSetup flightSetup;
    private ManagePassenger managePassenger;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FlightBookingManagementView flightView = new FlightBookingManagementView();
        flightView.init();
    }

    private void init() {
        flightSetup.flightSetUp();
        System.out.println("------------->Welcome To Flight Ticket Booking<------------");
        byte option = 0;
        while (true) {
            try {
                System.out.println("\nAdmin            Press 1");
                System.out.println("Passenger        Press 2");
                System.out.println("Exit             Press 3");
                System.out.println("Enter the Option");
                option = scanner.nextByte();
                if (option == 3) {
                    return;
                }
                switch (option) {
                    case 1:
                        manageAdmin.adminView();
                        break;
                    case 2:
                        managePassenger.passengerView();
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
        }
    }

    public FlightBookingManagementView() {
        manageAdmin = new ManageAdmin();
        managePassenger = new ManagePassenger();
        flightSetup = new FlightSetup();

    }
}
