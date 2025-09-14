
class Employee {
    // Static variable shared by all employees
    static String companyName = "TechCorp";
    
    // Static counter to keep track of total employees
    private static int totalEmployees = 0;
    
    // Final variable - employee ID cannot be modified once assigned
    private final int id;
    
    // Instance variables
    private String name;
    private String designation;
    
    // Constructor using 'this'
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++; // Increment when new employee is created
    }
    
    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }
    
    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Company: " + companyName);
        System.out.println("-----------------------------");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create employees
        Employee e1 = new Employee(101, "Alice", "Software Engineer");
        Employee e2 = new Employee(102, "Bob", "Data Analyst");
        
        // Use instanceof before printing details
        if (e1 instanceof Employee) {
            e1.displayDetails();
        }
        
        if (e2 instanceof Employee) {
            e2.displayDetails();
        }
        
        // Show total employees
        Employee.displayTotalEmployees();
    }
}
