package Vehicle;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {
    @Test
    public void testGettersAndSetters() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Ford");
        vehicle.setModel("F-150");

        assertEquals("Ford", vehicle.getMake());
        assertEquals("F-150", vehicle.getModel());
    }

    @Test
    public void testNullMake() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(null);
        vehicle.setModel("F-150");

        assertNull(vehicle.getMake());
        assertEquals("F-150", vehicle.getModel());
    }

    @Test
    public void testNullModel() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Ford");
        vehicle.setModel(null);

        assertEquals("Ford", vehicle.getMake());
        assertNull(vehicle.getModel());
    }
}