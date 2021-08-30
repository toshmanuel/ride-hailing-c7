package service;

import exceptions.UserAlreadyExistsException;
import user.Passenger;

import java.util.List;

public interface PassengerService {
    void createPassenger(Passenger passenger) throws UserAlreadyExistsException;
    void findPassenger(Passenger passenger);
    Passenger findPassengerById(String passengerId);
    List<Passenger> findPassengersByName(String firstName);
    void updatePassenger(Passenger passenger);
    void deletePassenger(Passenger passenger);

}
