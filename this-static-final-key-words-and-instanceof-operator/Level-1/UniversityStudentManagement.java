
class Student {
    // Static variable shared across all students
    static String universityName = "National University";
    
    // Static counter to track total students
    private static int totalStudents = 0;
    
    // Final variable - roll number cannot be changed once assigned
    private final int rollNumber;
    
    // Instance variables
    private String name;
    private String grade;
    
    // Constructor using 'this'
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++; // Increment student count on creation
    }
    
    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students in " + universityName + ": " + totalStudents);
    }
    
    // Method to update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated for Roll No. " + rollNumber + " to " + grade);
    }
    
    // Display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("University: " + universityName);
        System.out.println("-----------------------------");
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student(101, "Alice", "A");
        Student s2 = new Student(102, "Bob", "B");
        
        // Use instanceof before performing operations
        if (s1 instanceof Student) {
            s1.displayStudentDetails();
            s1.updateGrade("A+");
        }
        
        if (s2 instanceof Student) {
            s2.displayStudentDetails();
            s2.updateGrade("B+");
        }
        
        // Show total students
        Student.displayTotalStudents();
    }
}
