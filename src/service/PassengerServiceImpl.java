package service;

import db.PassengerDb;
import user.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private PassengerDb passengerDb;

    @Override
    public void createPassenger(Passenger passenger) {

    }

    @Override
    public void findPassenger(Passenger passenger) {

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

    public int count(){
        return passengerDb.count();
    }
}
