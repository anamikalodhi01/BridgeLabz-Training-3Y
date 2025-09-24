import java.util.ArrayList;

// Faculty class (Aggregation: can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

// Department class (Composition: cannot exist without University)
class Department {
    private String name;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    // Add faculty to department
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty); // Faculties can exist independently (aggregation)
    }

    public void showFaculties() {
        System.out.println("Faculties in " + name + " Department:");
        for (Faculty f : faculties) {
            System.out.println(f.getName());
        }
    }

    public String getName() { return name; }
}

// University class (Composition: owns Departments)
class University {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    // Add department to university
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Add faculty to a specific department
    public void addFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department d : departments) {
            if (d.getName().equals(deptName)) {
                d.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found!");
    }

    public void showUniversityStructure() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            System.out.println("Department: " + d.getName());
            d.showFaculties();
        }
    }

    // Delete university (all departments removed)
    public void removeUniversity() {
        departments.clear();
        System.out.println("University " + name + " removed. All departments deleted.");
    }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create faculty members (can exist independently)
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");
        Faculty f3 = new Faculty("Dr. Alice");

        // Create university
        University uni = new University("Global University");

        // Add departments (composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mathematics");

        // Add faculty to departments (aggregation)
        uni.addFacultyToDepartment("Computer Science", f1);
        uni.addFacultyToDepartment("Computer Science", f2);
        uni.addFacultyToDepartment("Mathematics", f3);

        // Show structure
        uni.showUniversityStructure();

        // Faculties can still exist independently
        System.out.println("Independent faculty: " + f1.getName());

        // Delete university (composition)
        uni.removeUniversity();
    }
}
