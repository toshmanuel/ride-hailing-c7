package service;

import db.PassengerDb;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import user.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private final PassengerDb passengerDb;

    public PassengerServiceImpl(){
        passengerDb = new PassengerDb();
    }

    @Override
    public void createPassenger(Passenger passenger) throws UserAlreadyExistsException {
        if (passengerDb.contains(passenger)){
            throw new UserAlreadyExistsException("Passenger already exist");
        }

        passengerDb.save(passenger);


    }

    @Override
    public Passenger findPassenger(Passenger passenger) throws UserNotFoundException {
        return passengerDb.find(passenger);
    }

    @Override
    public Passenger findPassengerById(String passengerId) {
        return null;
    }

    @Override
    public List<Passenger> findPassengersByName(String firstName) {
        return null;
    }

    @Override
    public void updatePassenger(Passenger passenger) {

    }

    @Override
    public void deletePassenger(Passenger passenger) {

    }

    public long count(){
        return passengerDb.count();
    }
}
