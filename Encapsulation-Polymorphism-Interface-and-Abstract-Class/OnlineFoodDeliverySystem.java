import java.util.ArrayList;

// Abstract class for FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method to calculate total price
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    // Encapsulation: Getters and Setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

// Interface for discountable items
interface Discountable {
    void applyDiscount(double percentage);
    void getDiscountDetails();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Discount on Veg Item: " + discount);
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private double additionalCharge = 50; // e.g., extra charge for non-veg preparation

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + additionalCharge - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Discount on Non-Veg Item: " + discount);
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<FoodItem> order = new ArrayList<>();

        VegItem paneer = new VegItem("Paneer Butter Masala", 200, 2);
        NonVegItem chicken = new NonVegItem("Chicken Biryani", 250, 1);

        // Apply discounts
        paneer.applyDiscount(10);   // 10% discount
        chicken.applyDiscount(5);   // 5% discount

        order.add(paneer);
        order.add(chicken);

        // Process order using polymorphism
        for (FoodItem item : order) {
            item.getItemDetails();

            if (item instanceof Discountable discountable) {
                discountable.getDiscountDetails();
            }

            System.out.println("Final Price to Pay: " + item.calculateTotalPrice());
            System.out.println("---------------------------");
        }
    }
}
