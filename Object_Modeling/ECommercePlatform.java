import java.util.ArrayList;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

// Order class (aggregates products)
class Order {
    private int orderId;
    private ArrayList<Product> products = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    // Add product to order
    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        double total = 0;
        for (Product p : products) {
            System.out.println("- " + p.getName() + ": $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public int getOrderId() { return orderId; }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    // Place an order (communication)
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.getOrderId());
    }

    public void showOrders() {
        System.out.println("Orders for " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }

    public String getName() { return name; }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Smartphone", 800);
        Product p3 = new Product("Headphones", 150);

        // Create customer
        Customer c1 = new Customer("Alice");

        // Create orders and add products
        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p3);

        Order o2 = new Order(102);
        o2.addProduct(p2);

        // Customer places orders
        c1.placeOrder(o1);
        c1.placeOrder(o2);

        // Display customer's orders
        c1.showOrders();
    }
}
