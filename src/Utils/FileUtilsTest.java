package Utils;

import org.junit.Test;

import Transport.Delivery;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileUtilsTest {

    @Test
    public void testWriteObjectsToFile() {
        Delivery delivery = new Delivery();
        delivery.setDistance(100);
        delivery.setDestinations("New York");
        delivery.setCargo("Food");
        delivery.setPrice(200);
        delivery.setPaid(true);
        List<Delivery> deliveries = new ArrayList<>();
        deliveries.add(delivery);

        String fileName = "test.txt";
        FileUtils.writeObjectsToFile(fileName, deliveries);
        File file = new File(fileName);
        assertTrue(file.exists());

        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testReadObjectsFromFile() {
        Delivery delivery = new Delivery();
        delivery.setDistance(100);
        delivery.setDestinations("New York");
        delivery.setCargo("Food");
        delivery.setPrice(200);
        delivery.setPaid(true);

        List<Delivery> deliveries = new ArrayList<>();
        deliveries.add(delivery);
        FileUtils.writeObjectsToFile("test.txt", deliveries);

        List<Object> objects = FileUtils.readObjectsFromFile("test.txt");
        assertTrue(objects.size() > 0);
        List<Delivery> readDeliveries = new ArrayList<>();
        for (Object object : objects) {
            if (object instanceof Delivery) {
                readDeliveries.add((Delivery) object);
            }
        }
        assertEquals(1, readDeliveries.size());
        assertEquals(delivery.getDistance(), readDeliveries.get(0).getDistance(), 0.01);
        assertEquals(delivery.getDestination(), readDeliveries.get(0).getDestination());
        assertEquals(delivery.getCargo(), readDeliveries.get(0).getCargo());
        assertEquals(delivery.getPrice(), readDeliveries.get(0).getPrice(), 0.01);
        assertEquals(delivery.isPaid(), readDeliveries.get(0).isPaid());
        
        File file = new File("test.txt");
        if (file.exists()) {
            file.delete();
        }
    }
}