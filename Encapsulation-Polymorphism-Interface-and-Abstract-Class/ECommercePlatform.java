import java.util.ArrayList;

// Abstract class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method for discount
    public abstract double calculateDiscount();

    // Concrete method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
    }

    // Getters and Setters (Encapsulation)
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

// Interface
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

// Electronics product
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax (GST 18%) for Electronics: " + calculateTax());
    }
}

// Clothing product
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax (GST 12%) for Clothing: " + calculateTax());
    }
}

// Groceries product (no tax)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        Electronics laptop = new Electronics(101, "Laptop", 50000);
        Clothing tshirt = new Clothing(102, "T-Shirt", 1000);
        Groceries rice = new Groceries(103, "Rice", 500);

        products.add(laptop);
        products.add(tshirt);
        products.add(rice);

        // Polymorphism: Calculate final price for each product
        for (Product p : products) {
            p.displayDetails();
            double tax = 0;
            if (p instanceof Taxable t) {
                tax = t.calculateTax();
                t.getTaxDetails();
            }
            double finalPrice = p.getPrice() + tax - p.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
            System.out.println("---------------------------");
        }
    }
}
