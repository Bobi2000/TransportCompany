import java.util.ArrayList;
import java.util.List;

import Transport.Delivery;
import Utils.FileUtils;

public class App {
    public static void main(String[] args) throws Exception {

        Delivery delivery1 = new Delivery();
        delivery1.setDistance(100);
        delivery1.setDestinations("Delivery");

        List<Delivery> data = new ArrayList<>();
        data.add(delivery1);

        FileUtils.writeObjectsToFile("test.txt", data);

        List<Object> objects = FileUtils.readObjectsFromFile("test.txt");

        List<Delivery> deliveries = new ArrayList<>();

        for (Object object : objects) {
            if (object instanceof Delivery) {
                deliveries.add((Delivery) object);
            }
        }

        System.out.print("");

        // TransportCompanyManager manager = new TransportCompanyManager();

        // TransportCompany company1 = new TransportCompany();
        // company1.setName("Acme Transport Co.");

        // TransportCompany company2 = new TransportCompany();
        // company2.setName("XYZ Transport Co.");

        // manager.addCompany(company1);
        // manager.addCompany(company2);

        // manager.deleteCompany(company1);

        // company2.setName("ABC Transport Co.");
        // manager.editCompany(company2);

    }
}
