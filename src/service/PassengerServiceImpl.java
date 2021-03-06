package service;

import db.PassengerDb;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import user.Passenger;
import user.PassengerUpdateForm;

import java.util.ArrayList;
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
    public Passenger findPassengerById(String passengerId) throws UserNotFoundException {
        return passengerDb.findById(passengerId);
    }

    @Override
    public List<Passenger> findPassengersByName(String name) throws UserNotFoundException{
        List<Passenger> passengers = new ArrayList<>();
        for (Passenger passenger :
             passengerDb.findAll()) {
            if (passenger.getFirstName().compareToIgnoreCase(name) == 0 || passenger.getLastName().compareToIgnoreCase(name) == 0) {
                passengers.add(passenger);
            }

            if (passengers.isEmpty()){
                throw new UserNotFoundException("User Not Found");
            }
        }
        return passengers;
    }

    @Override
    public void updatePassenger(String id, PassengerUpdateForm form) throws UserNotFoundException {
        Passenger passenger = findPassengerById(id);
        if (form.getFirstName() != null){
            passenger.setFirstName(form.getFirstName());
        }
        if (form.getLastName() != null) {
            passenger.setLastName(form.getLastName());
        }
        if (form.getPhoneNumber() != null){
            passenger.setPhoneNumber(form.getPhoneNumber());
        }
        if (form.getEmail() != null){
            passenger.setEmail(form.getEmail());
        }
        passengerDb.save(passenger);
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        passengerDb.delete(passenger);
    }

    public long count(){
        return passengerDb.count();
    }
}
