
class Patient {
    // Static variable shared among all patients
    static String hospitalName = "City Care Hospital";

    // Static counter to keep track of total patients
    private static int totalPatients = 0;

    // Final variable - unique for every patient
    private final int patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this'
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increase patient count on admission
    }

    // Static method to display total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients admitted in " + hospitalName + ": " + totalPatients);
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Hospital: " + hospitalName);
        System.out.println("-----------------------------");
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create patient objects
        Patient p1 = new Patient(1, "Alice", 30, "Fever");
        Patient p2 = new Patient(2, "Bob", 45, "Diabetes");

        // Use instanceof before displaying details
        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        // Display total patients
        Patient.getTotalPatients();
    }
}
