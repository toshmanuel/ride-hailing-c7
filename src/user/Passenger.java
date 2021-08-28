package user;

public class Passenger {

    private String phoneNumber;
    private String email;
    private String lastName;
    private String firstName;
    private String password;
    private String userId;

    public Passenger(String userId, String firstName, String lastName, String email, String phoneNumber, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
