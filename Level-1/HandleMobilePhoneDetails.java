class HandleMobilePhoneDetails {
    String brand;
    String model;
    double price;

    HandleMobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        HandleMobilePhoneDetails m1 = new HandleMobilePhoneDetails("Samsung", "Galaxy S23", 74999);
        m1.displayDetails();
    }
}
