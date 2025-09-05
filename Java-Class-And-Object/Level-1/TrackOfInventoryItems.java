class TrackOfInventoryItems {
    int itemCode;
    String itemName;
    double price;

    TrackOfInventoryItems(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        TrackOfInventoryItems i1 = new TrackOfInventoryItems(101, "Pen", 10.5);
        i1.displayDetails();
        System.out.println("Total Cost for 5 items: " + i1.calculateTotalCost(5));
    }
}
