
class Product {
    // Static variable shared by all products
    static double discount = 10.0; // Default discount in percentage
    
    // Final variable - unique product ID that cannot be changed
    private final int productID;
    
    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this'
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Method to calculate total price after discount
    public double calculateTotal() {
        double total = price * quantity;
        double discountedPrice = total - (total * discount / 100);
        return discountedPrice;
    }

    // Display product details
    public void displayProduct() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total after " + discount + "% discount: " + calculateTotal());
        System.out.println("-----------------------------");
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Create product objects
        Product p1 = new Product(101, "Laptop", 50000, 1);
        Product p2 = new Product(102, "Headphones", 2000, 2);

        // Check with instanceof before processing
        if (p1 instanceof Product) {
            p1.displayProduct();
        }
        if (p2 instanceof Product) {
            p2.displayProduct();
        }

        // Update discount globally
        Product.updateDiscount(20);

        // Display again after discount change
        if (p1 instanceof Product) {
            p1.displayProduct();
        }
        if (p2 instanceof Product) {
            p2.displayProduct();
        }
    }
}
