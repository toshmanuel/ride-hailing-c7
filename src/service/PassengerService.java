package service;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import user.Passenger;
import user.PassengerUpdateForm;

import java.util.List;

public interface PassengerService {
    void createPassenger(Passenger passenger) throws UserAlreadyExistsException;
    Passenger findPassenger(Passenger passenger) throws UserNotFoundException;
    Passenger findPassengerById(String passengerId) throws UserNotFoundException;
    List<Passenger> findPassengersByName(String firstName) throws UserNotFoundException;
    void updatePassenger(String id, PassengerUpdateForm form) throws UserNotFoundException;
    void deletePassenger(Passenger passenger);

}
