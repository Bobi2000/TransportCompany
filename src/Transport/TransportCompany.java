package Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Client.Client;
import Employee.Employee;
import Utils.FileUtils;
import Vehicle.Vehicle;

public class TransportCompany {
    private String name;
    private double funds;

    private List<Employee> employees;
    private List<Client> clients;
    private List<Vehicle> vehicles;
    private List<Delivery> deliveries;

    public TransportCompany() {
        this.funds = 0.00;

        this.employees = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.deliveries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void editEmployee(Employee employee) {
        int index = employees.indexOf(employee);
        employees.set(index, employee);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void deleteClient(Client client) {
        clients.remove(client);
    }

    public void editClient(Client client) {
        int index = clients.indexOf(client);
        clients.set(index, client);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void deleteVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void editVehicle(Vehicle vehicle) {
        int index = vehicles.indexOf(vehicle);
        vehicles.set(index, vehicle);
    }

    public List<Delivery> getDelivery() {
        return deliveries;
    }

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    public void deleteDelivery(Delivery delivery) {
        deliveries.remove(delivery);
    }

    public void editDelivery(Delivery delivery) {
        int index = deliveries.indexOf(delivery);

        deliveries.set(index, delivery);
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public void payForDelivery(Delivery delivery) {
        Client client = delivery.getClient();
        double price = delivery.getPrice();

        client.setFunds(client.getFunds() - price);
        delivery.setPaid(true);
        funds += price;
    }

    public void sortByEmployees() {
        this.employees = employees.stream()
                .sorted((a, b) -> {
                    int result = Float.compare(a.getYearsOfExperience(), b.getYearsOfExperience());

                    if (result == 0) {
                        result = Double.compare(a.getSalary(), b.getSalary());
                    }

                    return result;
                })
                .collect(Collectors.toList());
    }

    public void sortDeliverisByDestination() {
        this.deliveries = deliveries.stream()
                .sorted((a, b) -> {
                    return a.getDestination().compareTo(b.getDestination());
                })
                .collect(Collectors.toList());
    }

    public void saveDeliveriesToFile(String fileName) {
        FileUtils.writeObjectsToFile(fileName, this.deliveries);
    }

    public List<Delivery> readDeliveriesFromFile(String fileName) {
        List<Object> objects = FileUtils.readObjectsFromFile(fileName);

        List<Delivery> deliveries = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof Delivery) {
                deliveries.add((Delivery) object);
            }
        }

        return deliveries;
    }
}