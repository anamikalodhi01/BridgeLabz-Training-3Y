class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1000.0; // fixed rate for simplicity

    // Default constructor
    CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Basic";
        this.rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        return rentalDays * costPerDay;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + 
                           ", Days: " + rentalDays + ", Total Cost: " + calculateCost());
    }
}
