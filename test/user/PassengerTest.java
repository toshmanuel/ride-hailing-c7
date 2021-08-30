package user;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PassengerServiceImpl;

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
                "Titobi",
                "Ligali",
                "titobi.ligali@email.com",
                "09011467521",
                "AllahLovesYouTobi");

        passengerServiceImpl = new PassengerServiceImpl();
    }

    @Test
    @DisplayName("Create Passenger")
    void testThatPassengerCanBeCreated() {

        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            System.err.printf("%s: " , userAlreadyExistsException.getLocalizedMessage());
        }

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

        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            System.err.printf("%s: " , userAlreadyExistsException.getLocalizedMessage());
        }
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
        try {
            passengerServiceImpl.createPassenger(passenger1);
            passengerServiceImpl.createPassenger(passenger2);
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            System.err.printf("%s: " , userAlreadyExistsException.getLocalizedMessage());
        }
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
}