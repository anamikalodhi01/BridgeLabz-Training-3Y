import java.util.ArrayList;

// Employee class
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

// Department class
class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    // Add employee to department
    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void showEmployees() {
        System.out.println("Employees in " + name + " Department:");
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
}

// Company class
class Company {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    // Add department to company
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Add employee to a specific department
    public void addEmployeeToDepartment(String deptName, String employeeName) {
        for (Department d : departments) {
            if (d.getName().equals(deptName)) {
                d.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found!");
    }

    // Show all departments and their employees
    public void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            System.out.println("Department: " + d.getName());
            d.showEmployees();
        }
    }

    // Composition: Delete company (all departments and employees removed)
    public void removeCompany() {
        departments.clear();
        System.out.println("Company " + name + " removed. All departments and employees deleted.");
    }

    public String getName() { return name; }
}

// Main class
public class CompanyManagement {
    public static void main(String[] args) {
        // Create a company
        Company company = new Company("Tech Solutions");

        // Add departments
        company.addDepartment("HR");
        company.addDepartment("IT");

        // Add employees
        company.addEmployeeToDepartment("HR", "Alice");
        company.addEmployeeToDepartment("HR", "Bob");
        company.addEmployeeToDepartment("IT", "Charlie");
        company.addEmployeeToDepartment("IT", "David");

        // Show company structure
        company.showCompanyStructure();

        // Delete company (composition)
        company.removeCompany();
    }
}
