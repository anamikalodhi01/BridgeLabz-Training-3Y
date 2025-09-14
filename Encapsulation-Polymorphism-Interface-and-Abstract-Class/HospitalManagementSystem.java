import java.util.ArrayList;
import java.util.List;

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis; // Sensitive data
    private List<String> medicalHistory = new ArrayList<>(); // Sensitive data

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Encapsulation: restricted access to sensitive details
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void addToMedicalHistory(String record) {
        medicalHistory.add(record);
    }
}

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Subclass InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records = new ArrayList<>();

    public InPatient(int patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient Records: " + records);
    }
}

// Subclass OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient Records: " + records);
    }
}

// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient(101, "Rahul Sharma", 45, "Pneumonia", 5, 2000);
        OutPatient p2 = new OutPatient(102, "Anita Verma", 30, "Fever", 500);

        // Add medical records
        p1.addRecord("Admitted on 12th Sep");
        p1.addRecord("Prescribed antibiotics");
        p2.addRecord("Consulted on 13th Sep");
        p2.addRecord("Prescribed paracetamol");

        // Add to patient list
        patients.add(p1);
        patients.add(p2);

        // Polymorphism: process all patients
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Diagnosis: " + p.getDiagnosis());
            System.out.println("Bill Amount: " + p.calculateBill());

            if (p instanceof MedicalRecord record) {
                record.viewRecords();
            }

            System.out.println("-----------------------------");
        }
    }
}
