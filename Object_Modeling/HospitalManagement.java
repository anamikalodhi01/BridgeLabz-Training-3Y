import java.util.ArrayList;

// Patient class
class Patient {
    private String name;
    private ArrayList<Doctor> doctors = new ArrayList<>(); // Association: patient can have multiple doctors

    public Patient(String name) {
        this.name = name;
    }

    // Link patient to a doctor
    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void showDoctors() {
        System.out.println("Doctors consulting " + name + ":");
        for (Doctor d : doctors) {
            System.out.println(d.getName());
        }
    }

    public String getName() { return name; }
}

// Doctor class
class Doctor {
    private String name;
    private ArrayList<Patient> patients = new ArrayList<>(); // Association: doctor can have multiple patients

    public Doctor(String name) {
        this.name = name;
    }

    // Consult with a patient
    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this); // Link patient back to doctor
        System.out.println("Dr. " + name + " consulted patient " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Patients of Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println(p.getName());
        }
    }

    public String getName() { return name; }
}

// Hospital class
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) System.out.println(d.getName());
        System.out.println("Patients:");
        for (Patient p : patients) System.out.println(p.getName());
    }
}

// Main class
public class HospitalManagement {
    public static void main(String[] args) {
        // Create hospital
        Hospital hospital = new Hospital("City Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Smith");
        Doctor d2 = new Doctor("Johnson");

        // Create patients
        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");

        // Add doctors and patients to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Consultations (association + communication)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        // Show consultations
        d1.showPatients();
        d2.showPatients();
        p1.showDoctors();
        p2.showDoctors();
    }
}
