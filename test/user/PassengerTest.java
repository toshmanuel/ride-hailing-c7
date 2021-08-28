package user;

import db.PassengerDb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PassengerTest {

    PassengerDb passengerDb;
    @BeforeEach
    void setUp() {
        passengerDb = new PassengerDb();
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
                "08178746234",
                "AllahLovesYouTobi");

    }
}