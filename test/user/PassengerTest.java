package user;

import exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PassengerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PassengerTest {

    PassengerServiceImpl passengerServiceImpl;
    @BeforeEach
    void setUp() {
        passengerServiceImpl = new PassengerServiceImpl();
    }

    @Test
    @DisplayName("Create Passenger")
    void testThatPassengerCanBeCreated() {
        //given
        Passenger passenger1 = new Passenger("1",
                "Tobi",
                "Jolayemi",
                "tobi.jolayemi@email.com",
                "08178746234",
                "JesusLovesYou");

        Passenger passenger2 = new Passenger("2",
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

    }

    @Test
    @DisplayName("Passenger Already Exist Test")
    void testThatPassengerCannotBeCreatedIfItAlreadyExits() {
        Passenger passenger1 = new Passenger("1",
                "Tobi",
                "Jolayemi",
                "tobi.jolayemi@email.com",
                "08178746234",
                "JesusLovesYou");

        Passenger passenger2 = new Passenger("2",
                "Titobi",
                "Ligali",
                "titobi.ligali@email.com",
                "09011467521",
                "AllahLovesYouTobi");

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
}