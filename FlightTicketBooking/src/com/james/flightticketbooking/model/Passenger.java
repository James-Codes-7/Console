package model;

public class Passenger {

    private String passengerName;
    private byte Age;
    private String Gender;
    private int passengerId;
    private String ticketStatus;
    public String getPassengerName() {
        return passengerName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public byte getAge() {
        return Age;
    }

    public void setAge(byte age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
