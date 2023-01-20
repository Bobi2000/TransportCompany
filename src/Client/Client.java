package Client;

import java.io.Serializable;

public class Client implements Serializable {
    private String name;
    private String address;
    private String phoneNumber;
    private double funds;

    public Client() {
        this.funds = 0.00;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        if (funds < 0) {
            funds = 0.00;
        }
        this.funds = funds;
    }
}