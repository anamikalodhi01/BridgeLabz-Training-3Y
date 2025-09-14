import java.util.ArrayList;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
    }

    // Getters and Setters (Encapsulation)
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
}

// Interface for insurable vehicles
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

// Car subclass
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 5000; // Fixed insurance for simplicity
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Insurance Policy Number: " + policyNumber);
        System.out.println("Insurance Cost: " + calculateInsurance());
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 2000; // Fixed insurance for simplicity
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Insurance Policy Number: " + policyNumber);
        System.out.println("Insurance Cost: " + calculateInsurance());
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 8000; // Fixed insurance for simplicity
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Insurance Policy Number: " + policyNumber);
        System.out.println("Insurance Cost: " + calculateInsurance());
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car car = new Car("CAR123", 1500, "POLICY001");
        Bike bike = new Bike("BIKE456", 500, "POLICY002");
        Truck truck = new Truck("TRUCK789", 3000, "POLICY003");

        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        int rentalDays = 5;

        // Polymorphism: Process all vehicles
        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Rental Cost for " + rentalDays + " days: " + v.calculateRentalCost(rentalDays));

            if (v instanceof Insurable insurable) {
                insurable.getInsuranceDetails();
            }

            System.out.println("---------------------------");
        }
    }
}
