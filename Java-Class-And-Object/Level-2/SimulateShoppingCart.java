import java.util.ArrayList;

class SimulateShoppingCart {
    static class CartItem {
        String itemName;
        double price;
        int quantity;

        CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        double totalPrice() {
            return price * quantity;
        }
    }

    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(String itemName, double price, int quantity) {
        items.add(new CartItem(itemName, price, quantity));
        System.out.println(itemName + " added to cart.");
    }

    void removeItem(String itemName) {
        items.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        System.out.println(itemName + " removed from cart.");
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem item : items) {
            total += item.totalPrice();
        }
        System.out.println("Total Cart Cost: " + total);
    }

    public static void main(String[] args) {
        SimulateShoppingCart cart = new SimulateShoppingCart();
        cart.addItem("Laptop", 60000, 1);
        cart.addItem("Mouse", 1000, 2);
        cart.displayTotalCost();
        cart.removeItem("Mouse");
        cart.displayTotalCost();
    }
}
