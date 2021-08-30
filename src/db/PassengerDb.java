package db;

import user.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerDb {
    private final Map<String, Passenger> passengerMap;

    public PassengerDb() {
        passengerMap = new HashMap<>();
    }

    public long count() {
        return passengerMap.size();
    }

    public boolean contains(Passenger passenger) {
        return passengerMap.containsValue(passenger);
    }

    public void save(Passenger passenger) {
        passengerMap.put(passenger.getPassengerId(), passenger);
    }
}
