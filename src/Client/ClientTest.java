package Client;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {
    @Test
    public void testGettersAndSetters() {
        Client client = new Client();
        client.setName("John Doe");
        client.setAddress("123 Main St.");
        client.setPhoneNumber("(123) 456-7890");
        client.setFunds(1000.00);

        assertEquals("John Doe", client.getName());
        assertEquals("123 Main St.", client.getAddress());
        assertEquals("(123) 456-7890", client.getPhoneNumber());
        assertEquals(1000.00, client.getFunds(), 0.01);
    }

    @Test
    public void testNullValues() {
        Client client = new Client();
        client.setName(null);
        client.setAddress(null);
        client.setPhoneNumber(null);

        assertNull(client.getName());
        assertNull(client.getAddress());
        assertNull(client.getPhoneNumber());
    }

    @Test
    public void testNegativeFunds() {
        Client client = new Client();
        client.setFunds(-1000.00);

        assertEquals(0.00, client.getFunds(), 0.01);
    }
}