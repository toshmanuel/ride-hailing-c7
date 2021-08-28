package user;

import db.PassengerDb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PassengerService;
import service.PassengerServiceImpl;

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

        passengerServiceImpl.createPassenger()
        Passenger passenger2 = new Passenger("2",
                "Titobi",
                "Ligali",
                "titobi.ligali@email.com",
                "09011467521",
                "AllahLovesYouTobi");

    }
}