package user;

import java.util.Objects;

public class Passenger {

    private String phoneNumber;
    private String email;
    private String lastName;
    private String firstName;
    private String password;
    private String passengerId;

    public Passenger(String passengerId, String firstName, String lastName, String email, String phoneNumber, String password) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(phoneNumber, passenger.phoneNumber) || Objects.equals(email, passenger.email) || Objects.equals(passengerId, passenger.passengerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email, passengerId);
    }

    public String getPassengerId() {
        return passengerId;
    }
}
