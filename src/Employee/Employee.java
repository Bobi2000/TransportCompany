package Employee;

public class Employee {
    private String name;
    private double salary;
    private float yearsOfExperience;

    public Employee() {

    }

    public Employee(String name, double salary, float yearsOfExperience) {
        this.setName(name);
        this.setSalary(salary);
        this.setYearsOfExperience(yearsOfExperience);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            this.salary = 0.00;
        } else {
            this.salary = salary;
        }
    }

    public float getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        if (yearsOfExperience < 0) {
            this.yearsOfExperience = 0.00f;
        } else {
            this.yearsOfExperience = yearsOfExperience;
        }
    }
}