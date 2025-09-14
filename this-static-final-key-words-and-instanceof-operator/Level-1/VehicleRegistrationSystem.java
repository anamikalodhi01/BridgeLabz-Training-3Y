// Sample Program 6: Vehicle Registration System

class Vehicle {
    // Static variable shared across all vehicles
    static double registrationFee = 5000.0; // Default fee
    
    // Final variable - unique for every vehicle
    private final String registrationNumber;
    
    // Instance variables
    private String ownerName;
    private String vehicleType;
    
    // Constructor using 'this'
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    
    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }
    
    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("-----------------------------");
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Create vehicles
        Vehicle v1 = new Vehicle("MH12AB1234", "Alice", "Car");
        Vehicle v2 = new Vehicle("DL09XY5678", "Bob", "Bike");
        
        // Check with instanceof before displaying details
        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }
        
        if (v2 instanceof Vehicle) {
            v2.displayDetails();
        }
        
        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(6000.0);
        
        // Display again after updating fee
        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }
        
        if (v2 instanceof Vehicle) {
            v2.displayDetails();
        }
    }
}
