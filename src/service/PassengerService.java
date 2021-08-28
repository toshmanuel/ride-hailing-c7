package service;

import user.Passenger;

import java.util.List;

public interface PassengerService {
    void createPassenger(Passenger passenger);
    void findPassenger(Passenger passenger);
    Passenger findPassengerById(String passengerId);
    List<Passenger> findPassengersByName(String firstName);
    void updatePassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);

}
