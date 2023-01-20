package Employee;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void testGettersAndSetters() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setSalary(50000.00);
        employee.setYearsOfExperience(1.1f);

        assertEquals("John Doe", employee.getName());
        assertEquals(50000.00, employee.getSalary(), 0.01);
        assertEquals(1.1f, employee.getYearsOfExperience(), 0.01);
    }

    @Test
    public void testNullName() {
        Employee employee = new Employee();
        employee.setName(null);

        assertNull(employee.getName());
    }

    @Test
    public void testNegativeSalary() {
        Employee employee = new Employee();
        employee.setSalary(-50000.00);

        assertEquals(0.00, employee.getSalary(), 0.01);
    }

    @Test
    public void testNegativeYearsOfExperience() {
        Employee employee = new Employee();
        employee.setYearsOfExperience(-2f);

        assertEquals(0.00, employee.getSalary(), 0.01);
    }
}
