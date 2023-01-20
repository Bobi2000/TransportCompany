package Transport;

import java.io.Serializable;

import Client.Client;
import Vehicle.Vehicle;

public class Delivery implements Serializable {
    private Client client;
    private Vehicle vehicle;
    private double distance;
    private String destination;
    private String cargo;
    private double price;
    private boolean paid;

    public Delivery() {
        this.distance = 0.00;
        this.cargo = "";
        this.price = 0.00;
        this.paid = false;
        this.destination = "";
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance < 0) {
            distance = 0.00;
        }
        
        this.distance = distance;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestinations(String destination) {
        this.destination = destination;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null) {
            cargo = "";
        }

        this.cargo = cargo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            price = 0.00;
        }

        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}