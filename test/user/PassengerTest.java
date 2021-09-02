package user;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PassengerServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    PassengerServiceImpl passengerServiceImpl;
    Passenger passenger1;
    Passenger passenger2;
    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1",
                "Tobi",
                "Jolayemi",
                "tobi.jolayemi@email.com",
                "08178746234",
                "JesusLovesYou");

        passenger2 = new Passenger("2",
                "Tobi",
                "Ligali",
                "titobi.ligali@email.com",
                "09011467521",
                "AllahLovesYouTobi");

        passengerServiceImpl = new PassengerServiceImpl();
    }

    @Test
    @DisplayName("Create Passenger")
    void testThatPassengerCanBeCreated() {

        registerUser();

        assertEquals(2, passengerServiceImpl.count());

    }

    @Test
    @DisplayName("Passenger Already Exist Test")
    void testThatPassengerCannotBeCreatedIfItAlreadyExits() {

        Passenger passenger3 = new Passenger("2",
                "Titobi",
                "Ligali",
                "titobi.ligali@email.com",
                "09011467521",
                "AllahLovesYouTobi");

        registerUser();
        assertEquals(2, passengerServiceImpl.count());


        UserAlreadyExistsException exception = assertThrows(
                UserAlreadyExistsException.class,
                () -> passengerServiceImpl.createPassenger(passenger3)
        );

        assertEquals("Passenger already exist",
                exception.getLocalizedMessage());
    }

    @DisplayName("Find Passenger")
    @Test
    void testToFindPassenger(){
        registerUser();
        assertEquals(2, passengerServiceImpl.count());

        Passenger foundPassenger = null;
        try {
            foundPassenger = passengerServiceImpl.findPassenger(passenger2);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull(foundPassenger);
        assertEquals(foundPassenger, passenger2);
    }

    @DisplayName("Passenger Object Does Not Exist")
    @Test
    void testToThrowsExceptionIfPassengerObjectDoesNotExist() {
        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                ()-> passengerServiceImpl.findPassenger(passenger1));

        assertEquals("Passenger not found",
                exception.getLocalizedMessage());
    }

    @DisplayName("Find Passenger By Id")
    @Test
    void testToFindPassengerByPassengerId() {
        registerUser();
        Passenger foundPassenger = null;
        try {
            foundPassenger = passengerServiceImpl.findPassengerById("1");
        } catch (UserNotFoundException e) {
            System.err.printf("%s: " , e.getLocalizedMessage());
        }
        assertNotNull(foundPassenger);

        assertEquals("Jolayemi",foundPassenger.getLastName());
    }

    private void registerUser() {
        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            System.err.printf("%s: ", userAlreadyExistsException.getLocalizedMessage());
        }
    }

    @DisplayName("Find Passenger By Name")
    @Test
    void testToFindPassengerByPassengerFirstNameOrLastName() {
        registerUser();

        List<Passenger> foundPassengers = new ArrayList<>();
        try {
            foundPassengers = passengerServiceImpl.findPassengersByName("tOBi");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals(2, foundPassengers.size());
    }

    @DisplayName("Throw User Not Found Exception When User Does Not Exist")
    @Test
    void testToThrowExceptionWhenUserWithAParticularNameDoesNotExist(){

        registerUser();
        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                ()->passengerServiceImpl.findPassengersByName("TOBE"));
        assertEquals("User Not Found", exception.getLocalizedMessage());
    }

    @DisplayName("Update User")
    @Test
    void testToUpdateUsersInformation(){
        registerUser();

        Passenger foundPassenger = null;
        try {
            foundPassenger = passengerServiceImpl.findPassengerById("1");
        } catch (UserNotFoundException e) {
            System.err.printf("%s: " , e.getLocalizedMessage());
        }
        System.out.println(passenger1);
        assertNotNull(foundPassenger);

        assertEquals("Jolayemi",foundPassenger.getLastName());
        System.out.println(passenger1.toString());
        passenger1.setFirstName("Yinka");
        assertEquals("Yinka", passenger1.getFirstName());
        System.out.println(passenger1.toString());
        System.out.println(foundPassenger);
    }
}