package Transport;

import org.junit.Test;
import static org.junit.Assert.*;

public class TransportCompanyManagerTest {
    @Test
    public void testAddCompany() {
        TransportCompanyManager manager = new TransportCompanyManager();
        TransportCompany company = new TransportCompany();
        company.setName("Acme Inc.");
        manager.addCompany(company);
        assertEquals(1, manager.getCompanies().size());
        assertEquals("Acme Inc.", manager.getCompanies().get(0).getName());
    }

    @Test
    public void testDeleteCompany() {
        TransportCompanyManager manager = new TransportCompanyManager();
        TransportCompany company = new TransportCompany();
        company.setName("Acme Inc.");
        manager.addCompany(company);
        assertEquals(1, manager.getCompanies().size());
        manager.deleteCompany(company);
        assertEquals(0, manager.getCompanies().size());
    }

    @Test
    public void testEditCompany() {
        TransportCompanyManager manager = new TransportCompanyManager();
        TransportCompany company = new TransportCompany();
        company.setName("Acme Inc.");
        company.setFunds(1000.00);
        manager.addCompany(company);
        assertEquals(1, manager.getCompanies().size());
        assertEquals("Acme Inc.", manager.getCompanies().get(0).getName());
        assertEquals(1000.00, manager.getCompanies().get(0).getFunds(), 0.01);
        company.setName("Acme Corp.");
        company.setFunds(2000.00);
        manager.editCompany(company);
        assertEquals("Acme Corp.", manager.getCompanies().get(0).getName());
        assertEquals(2000.00, manager.getCompanies().get(0).getFunds(), 0.01);
    }

    @Test
    public void testSortCompanies() {
        TransportCompanyManager manager = new TransportCompanyManager();
        
        TransportCompany company1 = new TransportCompany();
        company1.setName("Acme Inc.");
        company1.setFunds(1000.00);

        TransportCompany company2 = new TransportCompany();
        company2.setName("Acme Corp.");
        company2.setFunds(2000.00);

        TransportCompany company3 = new TransportCompany();
        company3.setName("Acme Inc.");
        company3.setFunds(1500.00);

        manager.addCompany(company1);
        manager.addCompany(company2);
        manager.addCompany(company3);

        manager.sortCompanies();

        assertEquals("Acme Corp.", manager.getCompanies().get(0).getName());
        assertEquals(2000.00, manager.getCompanies().get(0).getFunds(), 0.01);
        assertEquals("Acme Inc.", manager.getCompanies().get(1).getName());
        assertEquals(1000.00, manager.getCompanies().get(1).getFunds(), 0.01);
        assertEquals("Acme Inc.", manager.getCompanies().get(2).getName());
        assertEquals(1500.00, manager.getCompanies().get(2).getFunds(), 0.01);
    }
}