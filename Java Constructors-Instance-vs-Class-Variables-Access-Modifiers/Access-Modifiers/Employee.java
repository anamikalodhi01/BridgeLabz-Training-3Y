// Base class
class Employee {
    public int employeeID;       // public
    protected String department; // protected
    private double salary;       // private

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Salary: " + salary);
    }
}

// Subclass
class Manager extends Employee {
    int teamSize;

    Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    void showDetails() {
        // can access employeeID (public) and department (protected)
        System.out.println("Manager ID: " + employeeID + ", Department: " + department + ", Team Size: " + teamSize);
    }
}
