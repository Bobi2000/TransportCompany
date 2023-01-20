package Transport;

import org.junit.Test;

import Client.Client;
import Vehicle.Vehicle;

import static org.junit.Assert.*;

public class DeliveryTest {
    @Test
    public void testGettersAndSetters() {
        Delivery delivery = new Delivery();

        Client client = new Client();
        client.setName("John Doe");
        delivery.setClient(client);

        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Ford");
        vehicle.setModel("F-150");
        delivery.setVehicle(vehicle);

        delivery.setDistance(100.00);
        delivery.setDestinations("Bremmen");
        delivery.setCargo("Household goods");
        delivery.setPrice(250.00);

        assertEquals(client, delivery.getClient());
        assertEquals(vehicle, delivery.getVehicle());
        assertEquals(100.00, delivery.getDistance(), 0.01);
        assertEquals("Bremmen", delivery.getDestination());
        assertEquals("Household goods", delivery.getCargo());
        assertEquals(250.00, delivery.getPrice(), 0.01);
    }

    @Test
    public void testNullClient() {
        Delivery delivery = new Delivery();
        delivery.setClient(null);

        assertNull(delivery.getClient());
    }

    @Test
    public void testNullVehicle() {
        Delivery delivery = new Delivery();
        delivery.setVehicle(null);

        assertNull(delivery.getVehicle());
    }

    @Test
    public void testNegativeDistance() {
        Delivery delivery = new Delivery();
        delivery.setDistance(-100.00);

        assertEquals(0.00, delivery.getDistance(), 0.01);
    }

    @Test
    public void testNullCargo() {
        Delivery delivery = new Delivery();
        delivery.setCargo(null);

        assertEquals("", delivery.getCargo());
    }

    @Test
    public void testNegativePrice() {
        Delivery delivery = new Delivery();
        delivery.setPrice(-250.00);

        assertEquals(0.00, delivery.getPrice(), 0.01);
    }
}