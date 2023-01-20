package Transport;

import org.junit.Test;

import Client.Client;
import Employee.Employee;
import Vehicle.Vehicle;

import static org.junit.Assert.*;

import java.util.List;

public class TransportCompanyTest {
    @Test
    public void testGettersAndSetters() {
        TransportCompany company = new TransportCompany();
        company.setName("Acme Transport Co.");

        assertEquals("Acme Transport Co.", company.getName());
    }

    @Test
    public void testEmployeeOperations() {
        TransportCompany company = new TransportCompany();

        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setSalary(50000.00);

        Employee employee2 = new Employee();
        employee2.setName("Jane Doe");
        employee2.setSalary(60000.00);

        // Add employees
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        // Verify that employees were added
        assertEquals(2, company.getEmployees().size());
        assertTrue(company.getEmployees().contains(employee1));
        assertTrue(company.getEmployees().contains(employee2));

        // Edit employee
        employee1.setSalary(55000.00);
        company.editEmployee(employee1);

        // Verify that employee was edited
        assertEquals(55000.00, employee1.getSalary(), 0.01);

        // Delete employee
        company.deleteEmployee(employee1);

        // Verify that employee was deleted
        assertEquals(1, company.getEmployees().size());
        assertFalse(company.getEmployees().contains(employee1));
    }

    @Test
    public void testClientOperations() {
        TransportCompany company = new TransportCompany();

        Client client1 = new Client();
        client1.setName("John Doe");
        client1.setAddress("123 Main St.");
        client1.setPhoneNumber("(123) 456-7890");

        Client client2 = new Client();
        client2.setName("Jane Doe");
        client2.setAddress("456 Second Ave.");
        client2.setPhoneNumber("(234) 567-8901");

        // Add clients
        company.addClient(client1);
        company.addClient(client2);

        // Verify that clients were added
        assertEquals(2, company.getClients().size());
        assertTrue(company.getClients().contains(client1));
        assertTrue(company.getClients().contains(client2));

        // Edit client
        client1.setAddress("789 Third Ave.");
        company.editClient(client1);

        // Verify that client was edited
        assertEquals("789 Third Ave.", client1.getAddress());

        // Delete client
        company.deleteClient(client1);

        // Verify that client was deleted
        assertEquals(1, company.getClients().size());
        assertFalse(company.getClients().contains(client1));
    }

    @Test
    public void testVehicleOperations() {
        TransportCompany company = new TransportCompany();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setMake("Ford");
        vehicle1.setModel("F-150");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setMake("Toyota");
        vehicle2.setModel("Camry");

        // Add vehicles
        company.addVehicle(vehicle1);
        company.addVehicle(vehicle2);

        // Verify that vehicles were added
        assertEquals(2, company.getVehicles().size());
        assertTrue(company.getVehicles().contains(vehicle1));
        assertTrue(company.getVehicles().contains(vehicle2));

        // Edit vehicle
        vehicle1.setModel("Explorer");
        company.editVehicle(vehicle1);

        // Verify that vehicle was edited
        assertEquals("Explorer", vehicle1.getModel());

        // Delete vehicle
        company.deleteVehicle(vehicle1);

        // Verify that vehicle was deleted
        assertEquals(1, company.getVehicles().size());
        assertFalse(company.getVehicles().contains(vehicle1));
    }

    @Test
    public void testDeliveryOperations() {
        TransportCompany company = new TransportCompany();

        Delivery delivery1 = new Delivery();
        delivery1.setCargo("Beer");
        delivery1.setDistance(100d);
        delivery1.setPrice(10000d);
        delivery1.setPaid(false);

        Delivery delivery2 = new Delivery();
        delivery2.setCargo("Wine");
        delivery2.setDistance(200d);
        delivery2.setPrice(30000d);
        delivery2.setPaid(false);

        // Add delivery
        company.addDelivery(delivery1);
        company.addDelivery(delivery2);

        // Verify that deliveries were added
        assertEquals(2, company.getDelivery().size());
        assertTrue(company.getDelivery().contains(delivery1));
        assertTrue(company.getDelivery().contains(delivery2));

        // Edit delivery
        delivery1.setCargo("Beer2");
        company.editDelivery(delivery1);

        // Verify that delivery was edited
        assertEquals("Beer2", delivery1.getCargo());

        // Delete delivery
        company.deleteDelivery(delivery1);

        // Verify that delivery was deleted
        assertEquals(1, company.getDelivery().size());
        assertFalse(company.getDelivery().contains(delivery1));
    }

    @Test
    public void testSortEmployees() {
        TransportCompany company = new TransportCompany();
        company.setName("Acme Inc.");
        company.setFunds(100000.00);

        Employee employee1 = new Employee("John", 2200f, 1);
        Employee employee2 = new Employee("Carter", 3000f, 2);
        Employee employee3 = new Employee("Peter", 5500f, 3.5f);
        Employee employee4 = new Employee("Walter", 4500f, 3.5f);

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);
        company.addEmployee(employee4);

        company.sortByEmployees();

        assertEquals("John", company.getEmployees().get(0).getName());
        assertEquals("Carter", company.getEmployees().get(1).getName());
        assertEquals("Walter", company.getEmployees().get(2).getName());
        assertEquals("Peter", company.getEmployees().get(3).getName());
    }

    @Test
    public void testSortDeliviersByDestination() {
        TransportCompany company = new TransportCompany();
        company.setName("Acme Inc.");
        company.setFunds(100000.00);

        Delivery delivery1 = new Delivery();
        delivery1.setDestinations("Bremmen");
        Delivery delivery2 = new Delivery();
        delivery2.setDestinations("Berlin");
        Delivery delivery3 = new Delivery();
        delivery3.setDestinations("Munchen");

        company.addDelivery(delivery1);
        company.addDelivery(delivery2);
        company.addDelivery(delivery3);

        company.sortDeliverisByDestination();

        assertEquals("Berlin", company.getDelivery().get(0).getDestination());
        assertEquals("Bremmen", company.getDelivery().get(1).getDestination());
        assertEquals("Munchen", company.getDelivery().get(2).getDestination());
    }

    @Test
    public void testReadDeliveriesFromFile() {
        TransportCompany company = new TransportCompany();
        company.setName("Acme Inc.");
        company.setFunds(100000.00);

        Delivery delivery1 = new Delivery();
        delivery1.setDistance(100f);
        delivery1.setDestinations("Bremmen");

        company.addDelivery(delivery1);

        String fileName = "test.txt";

        company.saveDeliveriesToFile(fileName);
        List<Delivery> deliveries = company.readDeliveriesFromFile(fileName);

        assertEquals(deliveries.size(), 1);
        assertEquals("Bremmen", deliveries.get(0).getDestination());
    }
}